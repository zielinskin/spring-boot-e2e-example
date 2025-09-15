package zielinskin.springboote2e.school.api;

import zielinskin.common.logic.CrudService;

import java.util.List;

public interface StudentService extends CrudService<Student, Integer> {
    List<Student> search(Double gradeLowerThan);
    void applyCurve(Double factor);
}
