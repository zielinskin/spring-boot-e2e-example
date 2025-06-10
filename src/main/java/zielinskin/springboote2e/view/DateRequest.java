package zielinskin.springboote2e.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class DateRequest {

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updated;

    public DateRequest(@JsonProperty("updated") LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }
}
