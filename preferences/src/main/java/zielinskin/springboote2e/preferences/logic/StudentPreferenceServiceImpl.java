package zielinskin.springboote2e.preferences.logic;

import org.springframework.stereotype.Service;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.preferences.api.ResolvedStudentPreference;
import zielinskin.springboote2e.preferences.api.StudentPreference;
import zielinskin.springboote2e.preferences.api.StudentPreferenceService;
import zielinskin.springboote2e.preferences.data.StudentPreferenceEntity;
import zielinskin.springboote2e.preferences.data.StudentPreferenceRepository;
import zielinskin.springboote2e.school.api.StudentService;

import java.util.NoSuchElementException;

@Service
class StudentPreferenceServiceImpl extends
        AbstractCrudService<StudentPreferenceEntity,
                StudentPreference,
                Integer,
                StudentPreferenceRepository>
        implements StudentPreferenceService {
    private final DishService dishService;
    private final StudentService studentService;

    public StudentPreferenceServiceImpl(StudentPreferenceRepository repository, BiMapper<StudentPreference, StudentPreferenceEntity> mapper,
                                        DishService dishService,
                                        StudentService studentService) {
        super(repository, mapper);
        this.dishService = dishService;
        this.studentService = studentService;
    }

    @Override
    public ResolvedStudentPreference getResolvedStudentPreference(Integer id) {
        StudentPreference studentPreference = get(id)
                .orElseThrow(NoSuchElementException::new);

        return new ResolvedStudentPreference(
                studentService.get(studentPreference.studentId())
                        .orElseThrow(NoSuchElementException::new),
                dishService.getDish(studentPreference.dishId(),
                        studentPreference.dishType()));
    }
}
