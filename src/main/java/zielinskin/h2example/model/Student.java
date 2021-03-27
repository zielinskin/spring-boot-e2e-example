package zielinskin.h2example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private final Integer id;
    private final String name;

    public Student(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
