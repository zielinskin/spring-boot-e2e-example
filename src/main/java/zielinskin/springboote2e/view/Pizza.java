package zielinskin.springboote2e.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Pizza {
    private final Integer id;
    private final String crust;
    private final String type;
    private final Integer size;

    public Pizza(@JsonProperty("id") Integer id,
                 @JsonProperty("crust") String crust,
                 @JsonProperty("type") String type,
                 @JsonProperty("size") Integer size) {
        this.id = id;
        this.crust = crust;
        this.type = type;
        this.size = size;
    }

    public Integer getId() {
        return id;
    }

    public String getCrust() {
        return crust;
    }

    public String getType() {
        return type;
    }

    public Integer getSize() {
        return size;
    }
}
