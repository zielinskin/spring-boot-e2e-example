package zielinskin.springboote2e.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record Lecture(Integer id, String name, Set<Student> students) {
}
