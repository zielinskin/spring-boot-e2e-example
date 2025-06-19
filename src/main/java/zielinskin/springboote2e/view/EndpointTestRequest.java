package zielinskin.springboote2e.view;


import org.springframework.util.LinkedMultiValueMap;

public record EndpointTestRequest(String url,
                                  String method,
                                  LinkedMultiValueMap<String, String> headers,
                                  String body,
                                  Integer totalRequests,
                                  Integer threads) {
}
