package zielinskin.springboote2e.logic;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zielinskin.springboote2e.configuration.CrossInstancePropertySource;
import zielinskin.springboote2e.view.Pasta;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrossInstanceService {
    private final CrossInstancePropertySource crossInstancePropertySource;
    private final RestTemplate restTemplate;
    private final List<Pasta> instanceList = new ArrayList<>();

    public CrossInstanceService(CrossInstancePropertySource crossInstancePropertySource,
                                RestTemplateBuilder restTemplateBuilder) {
        this.crossInstancePropertySource = crossInstancePropertySource;
        this.restTemplate = restTemplateBuilder.build();

        for(int i = 0; i < crossInstancePropertySource.getNumberOfObjectInstances(); i++) {
            instanceList.add(new Pasta(i,
                    "name" + i,
                    "sauce" + i,
                    "meatType" + i
                    ));
        }
    }

    public List<Pasta> getInstanceList(Integer remainingCalls) {
        if(remainingCalls <= 0) {
            return instanceList;
        } else {
            return restTemplate.exchange(String.format("http://%s/cross-instance/cross-calls/%d",
                    crossInstancePropertySource.getExternalInstanceIp(),
                    remainingCalls - 1),
                    HttpMethod.GET,
                    new HttpEntity<>(null),
                    new ParameterizedTypeReference<List<Pasta>>(){})
                    .getBody();
        }
    }
}
