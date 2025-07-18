package zielinskin.springboote2e.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public class Lecture {
    public final Integer id;
    public final String name;
    public final Set<Student> students;

    public Lecture(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("students") Set<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Student> getStudents() {
        return students;
    }
}
