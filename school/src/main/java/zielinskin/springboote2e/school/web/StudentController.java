package zielinskin.springboote2e.school.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zielinskin.common.logic.CrudService;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.school.logic.StudentService;
import zielinskin.springboote2e.school.view.Student;

import java.util.List;

@RestController
@RequestMapping("/students")
class StudentController extends AbstractCrudController<Student, Integer, StudentService> {
    public StudentController(StudentService service) {
        super(service);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam("gradeLowerThan") Double gradeLowerThan) {
        return service.search(gradeLowerThan);
    }

    @PostMapping("/applyCurve")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void applyCurve(@RequestBody Double factor) {
        service.applyCurve(factor);
    }
}