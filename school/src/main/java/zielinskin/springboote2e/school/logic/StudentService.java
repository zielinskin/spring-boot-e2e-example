package zielinskin.springboote2e.school.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.school.data.StudentEntity;
import zielinskin.springboote2e.school.data.StudentRepository;
import zielinskin.springboote2e.school.view.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService extends AbstractCrudService<StudentEntity, Student, Integer, StudentRepository> {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository repository,
                          BiMapper<Student, StudentEntity> mapper) {
        super(repository, mapper);
    }

    public List<Student> search(Double gradeLowerThan) {
        return repository.findByGradeLessThanEqual(gradeLowerThan).stream()
                .map(mapper::mapToView)
                .collect(Collectors.toList());
    }

    public void applyCurve(Double factor) {
        repository.saveAll(repository.findAll().stream()
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
