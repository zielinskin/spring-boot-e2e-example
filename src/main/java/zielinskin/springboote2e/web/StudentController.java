package zielinskin.springboote2e.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zielinskin.springboote2e.logic.StudentService;
import zielinskin.springboote2e.view.Student;

import java.util.List;

@RestController
@RequestMapping("/students")
class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody Student view) {
        service.save(view);
    }

    @GetMapping()
    public List<Student> get() {
        return service.get();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Integer id) {
        return service.get(id);
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam("gradeLowerThan") Double gradeLowerThan) {
        return service.search(gradeLowerThan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }


    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT}, value = "/bulk")
    public void saveBulk(@RequestBody List<Student> view) {
        service.save(view);
    }

    @PostMapping("/applyCurve")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void applyCurve(@RequestBody Double factor) {
        service.applyCurve(factor);
    }
}