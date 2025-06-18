package zielinskin.springboote2e.logic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;
import zielinskin.springboote2e.view.EndpointTestRequest;
import zielinskin.springboote2e.view.EndpointTestResults;
import zielinskin.springboote2e.view.RequestResult;
import zielinskin.springboote2e.web.EndpointTestController;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Service
public class EndpointTestService {
    private static final Logger log = LoggerFactory.getLogger(EndpointTestController.class);
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public EndpointTestService(ObjectMapper objectMapper) {
        this.restTemplate = new RestTemplate();
        this.objectMapper = objectMapper;
    }

    public EndpointTestResults testEndpoint(EndpointTestRequest testRequest) {
        int defaultRequestsPerThread = testRequest.totalRequests() / testRequest.threads();
        int totalThreadsWithExtraRequest = testRequest.totalRequests() % testRequest.threads();

        List<Callable<List<RequestResult>>> tasks = new ArrayList<>(testRequest.threads());
        for (int i = 0; i < testRequest.threads(); i++) {
            if (i <= totalThreadsWithExtraRequest - 1) {
                tasks.add(() ->
                        run(defaultRequestsPerThread + 1, testRequest));
            } else {
                tasks.add(() ->
                        run(defaultRequestsPerThread, testRequest));
            }
        }
        List<RequestResult> results;
        try (ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(testRequest.threads())) {
            results = threadPoolExecutor.invokeAll(tasks).stream()
                    .map(this::getFromFuture)
                    .filter(Objects::nonNull)
                    .flatMap(Collection::stream)
                    .toList();
        } catch (Exception e) {
            log.error("Error in endpoint test service executing results:", e);
            results = new ArrayList<>();
        }
        return new EndpointTestResults(
                results.stream()
                        .mapToLong(RequestResult::requestMs)
                        .average()
                        .orElse(0d),
                results.stream()
                        .mapToLong(RequestResult::requestMs)
                        .max()
                        .orElse(0),
                results.stream()
                        .mapToLong(RequestResult::requestMs)
                        .min()
                        .orElse(0),
                (double) results.stream()
                        .filter(RequestResult::successful)
                        .count() / (long) results.size() * 100d,
                results.size());
    }

    private List<RequestResult> run(Integer timesToRun, EndpointTestRequest testRequest) {
        List<RequestResult> results = new ArrayList<>();
        for (int i = 0; i < timesToRun; i++) {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();

            Map<String, String> map;
            try {
                map = objectMapper.readValue(testRequest.headers(), new TypeReference<Map<String, String>>() {
                });
            } catch (Exception e) {
                log.error("Error in endpoint test service:", e);
                throw new RuntimeException(e);
            }
            map.forEach(headers::add);

            HttpEntity<String> entity = new HttpEntity<>(testRequest.body(), headers);
            ResponseEntity<String> responseEntity = restTemplate.exchange(testRequest.url(),
                    HttpMethod.valueOf(testRequest.method()),
                    entity, String.class);
            stopWatch.stop();
            results.add(new RequestResult(
                    stopWatch.getTotalTimeMillis(),
                    responseEntity.getStatusCode().value(),
                    responseEntity.getStatusCode().is2xxSuccessful()));
        }
        return results;
    }

    private <T> T getFromFuture(Future<T> future) {
        try {
            return future.get();
        } catch (Exception e) {
            return null;
        }
    }
}