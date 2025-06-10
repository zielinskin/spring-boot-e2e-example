package zielinskin.springboote2e.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zielinskin.springboote2e.Application;
import zielinskin.springboote2e.data.StudentEntity;
import zielinskin.springboote2e.data.StudentRepository;
import zielinskin.springboote2e.view.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public void save(Student view) {
        studentRepository.save(mapToEntity(view));
    }

    public void save(List<Student> views) {
        studentRepository.saveAll(views.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toSet()));
    }

    public List<Student> get() {
        return studentRepository.findAll().stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    public Student get(Integer id) {
        return studentRepository.findById(id)
                .map(this::mapToView)
                .orElseThrow(() ->
                        new RuntimeException("There wasn't one, duh."));
    }

    public List<Student> search(Double gradeLowerThan) {
        return studentRepository.findByGradeLessThanEqual(gradeLowerThan).stream()
                .map(this::mapToView)
                .collect(Collectors.toList());
    }

    public void applyCurve(Double factor) {
        studentRepository.saveAll(studentRepository.findAll().stream()
                .peek(entity ->
                        entity.setGrade(entity.getGrade() * factor))
                .collect(Collectors.toSet()));
    }

    @Scheduled(initialDelay = 1000, fixedDelay = 5000)
    void runThing() {
        logger.info("Running logging good case in student service...");
        throw new RuntimeException("Throwing exception from scheduled task.");
    }

    private Student mapToView(StudentEntity entity) {
        return new Student(entity.getId(),
                entity.getName(),
                entity.getGrade());
    }

    private StudentEntity mapToEntity(Student model) {
        StudentEntity entity = new StudentEntity();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setGrade(model.getGrade());

        return entity;
    }
}
