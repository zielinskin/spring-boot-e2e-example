package zielinskin.springboote2e.view;

public record EndpointTestResults(Double averageMs,
                                  Long maxMs,
                                  Long minMs,
                                  Double percentageSuccessful,
                                  Integer totalRan) {
}
