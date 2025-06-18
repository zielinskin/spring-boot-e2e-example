package zielinskin.springboote2e.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.springboote2e.logic.EndpointTestService;
import zielinskin.springboote2e.view.EndpointTestRequest;
import zielinskin.springboote2e.view.EndpointTestResults;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EndpointTestController {
    private static final Logger log = LoggerFactory.getLogger(EndpointTestController.class);
    private final EndpointTestService endpointTestService;
    private final ObjectMapper objectMapper;

    public EndpointTestController(EndpointTestService endpointTestService, ObjectMapper objectMapper) {
        this.endpointTestService = endpointTestService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/test/test-endpoint")
    public EndpointTestResults testEndpoint(EndpointTestRequest endpointTestRequest) {
        return endpointTestService.testEndpoint(endpointTestRequest);
    }

    @GetMapping("test/map")
    public Map<String, String> getMap() {
        Map<String, String> map = new HashMap<>();
        map.put("Test", "test2");
        map.put("test3", "test4");
        return map;
    }

    @PostMapping("test/map")
    public void postMap(@RequestBody Map<String, String> map) {
        try {
            log.info(objectMapper.writeValueAsString(map));
        } catch (Exception e) {

        }
    }
}
