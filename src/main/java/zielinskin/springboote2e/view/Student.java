package zielinskin.springboote2e.view;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private final Integer id;
    private final String name;
    private final Double grade;

    @JsonCreator
    public Student(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("grade") Double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Student() {
        this.id = null;
        this.name = "default";
        this.grade = 0d;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public Double getGrade() {
        return grade;
    }
}
