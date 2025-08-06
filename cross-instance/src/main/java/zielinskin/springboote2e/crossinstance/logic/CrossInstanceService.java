package zielinskin.springboote2e.crossinstance.logic;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zielinskin.springboote2e.crossinstance.configuration.CrossInstancePropertySource;
import zielinskin.springboote2e.crossinstance.view.DataHoldingRecord;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrossInstanceService {
    private final CrossInstancePropertySource crossInstancePropertySource;
    private final RestTemplate restTemplate;
    private final List<DataHoldingRecord> instanceList = new ArrayList<>();

    public CrossInstanceService(CrossInstancePropertySource crossInstancePropertySource,
                                RestTemplateBuilder restTemplateBuilder) {
        this.crossInstancePropertySource = crossInstancePropertySource;
        this.restTemplate = restTemplateBuilder.build();

        for(int i = 0; i < crossInstancePropertySource.numberOfObjectInstances(); i++) {
            instanceList.add(new DataHoldingRecord(i,
                    "name" + i,
                    "sauce" + i,
                    "meatType" + i
            ));
        }
    }

    public List<DataHoldingRecord> getInstanceList(Integer remainingCalls) {
        if(remainingCalls <= 0) {
            return instanceList;
        } else {
            return restTemplate.exchange(String.format("http://%s:8080/cross-instance/cross-calls/%d",
                                    crossInstancePropertySource.externalInstanceIp(),
                                    remainingCalls - 1),
                            HttpMethod.GET,
                            new HttpEntity<>(null),
                            new ParameterizedTypeReference<List<DataHoldingRecord>>(){})
                    .getBody();
        }
    }
}

