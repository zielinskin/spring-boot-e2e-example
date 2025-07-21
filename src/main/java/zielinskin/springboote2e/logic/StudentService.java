package zielinskin.springboote2e.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zielinskin.springboote2e.data.StudentRepository;
import zielinskin.springboote2e.view.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository,
                          StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }

    public void save(Student view) {
        studentRepository.save(studentMapper.mapToEntity(view));
    }

    public void save(List<Student> views) {
        studentRepository.saveAll(views.stream()
                .map(studentMapper::mapToEntity)
                .collect(Collectors.toSet()));
    }

    public List<Student> get() {
        return studentRepository.findAll().stream()
                .map(studentMapper::mapToView)
                .collect(Collectors.toList());
    }

    public Student get(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::mapToView)
                .orElseThrow(() ->
                        new RuntimeException("There wasn't one, duh."));
    }

    public List<Student> search(Double gradeLowerThan) {
        return studentRepository.findByGradeLessThanEqual(gradeLowerThan).stream()
                .map(studentMapper::mapToView)
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
}
