package zielinskin.springboote2e.school.api;

import java.util.Set;

public record Lecture(Integer id, String name, Set<Student> students) {
}
