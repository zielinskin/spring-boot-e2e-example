package zielinskin.springboote2e.view;


import java.util.Map;

public record EndpointTestRequest(String url,
                                  String method,
                                  String headers,
                                  String body,
                                  Integer totalRequests,
                                  Integer threads) {
}
