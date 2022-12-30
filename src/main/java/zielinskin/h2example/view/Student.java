package zielinskin.h2example.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Student {
    private final Integer id;
    private final String name;
    private final Double grade;
    private final Lecture lecture;

    public Student(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("grade") Double grade,
                   @JsonProperty("lecture") Lecture lecture) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.lecture = lecture;
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

    @JsonIgnore
    public Lecture getLecture() {
        return lecture;
    }
}
