package zielinskin.h2example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EndpointTestRequest {
    private final String endpoint;
    private final String authorizationHeader;

    public EndpointTestRequest(@JsonProperty("endpoint") String endpoint,
                               @JsonProperty("authorizationHeader") String authorizationHeader) {
        this.endpoint = endpoint;
        this.authorizationHeader = authorizationHeader;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public String getAuthorizationHeader() {
        return authorizationHeader;
    }
}
