package zielinskin.h2example.web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import zielinskin.h2example.model.EndpointTestRequest;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EndpointTestController {

    @PostMapping("/testEndpoint")
    public Long testEndPoint(@RequestBody EndpointTestRequest endpointTestRequest) {
        Map<String, String> headers = new HashMap<>();
        if(endpointTestRequest.getAuthorizationHeader() != null ){
            headers.put("Authorization", endpointTestRequest.getAuthorizationHeader());
        }

        HttpEntity entity = new HttpEntity(headers);

        Long start = System.currentTimeMillis();
        new RestTemplate().exchange(
                endpointTestRequest.getEndpoint(), HttpMethod.GET, entity, String.class);
        Long done = System.currentTimeMillis();
        return done - start;
    }
}
