package zielinskin.springboote2e.preferences.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.preferences.api.ResolvedStudentPreference;
import zielinskin.springboote2e.preferences.api.StudentPreference;
import zielinskin.springboote2e.preferences.api.StudentPreferenceService;

@RestController
@RequestMapping("/preferences")
class StudentPreferenceController extends AbstractCrudController<StudentPreference, Integer, StudentPreferenceService> {
    public StudentPreferenceController(StudentPreferenceService service) {
        super(service);
    }

    @GetMapping("/{id}/resolved")
    public ResolvedStudentPreference getResolvedStudentPreference(@PathVariable("id") Integer id) {
        return service.getResolvedStudentPreference(id);
    }
}
