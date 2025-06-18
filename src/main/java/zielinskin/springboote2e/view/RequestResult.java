package zielinskin.springboote2e.view;

public record RequestResult(Long requestMs,
                            Integer responseCode,
                            Boolean successful) {
}
