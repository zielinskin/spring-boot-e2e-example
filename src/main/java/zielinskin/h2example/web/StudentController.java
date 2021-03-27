package zielinskin.h2example.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.h2example.logic.StudentService;
import zielinskin.h2example.model.Student;

import java.util.List;

@RestController
@RequestMapping("/students")
class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody Student studentEntity) {
        service.save(studentEntity);
    }

    @GetMapping()
    public List<Student> get() {
        return service.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
