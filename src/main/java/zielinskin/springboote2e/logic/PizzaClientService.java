package zielinskin.springboote2e.logic;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import zielinskin.springboote2e.view.Pizza;

@Service
public class PizzaClientService {
    private final RestTemplate restTemplate;

    public PizzaClientService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public Pizza getById(Integer id) {
        return restTemplate.getForObject(String.format("http://localhost:8080/api/pizzas/%d", id),
                Pizza.class);
    }

    public String throwError(Integer id) {
        return restTemplate.getForObject(String.format("http://localhost:8080/api/pizzas/errors/%d", id),
                String.class);
    }
}
