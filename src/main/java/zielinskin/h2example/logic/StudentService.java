package zielinskin.h2example.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.data.StudentRepository;
import zielinskin.h2example.view.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class StudentService {
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
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    public Student get(Integer id) {
        return studentRepository.findById(id)
                .map(this::mapToModel)
                .orElseThrow(() ->
                        new RuntimeException("There wasn't one, duh."));
    }

    public List<Student> search(Double gradeLowerThan) {
        return studentRepository.findByGradeLessThanEqual(gradeLowerThan).stream()
                .map(this::mapToModel)
                .collect(Collectors.toList());
    }

    public void applyCurve(Double factor) {
        studentRepository.saveAll(studentRepository.findAll().stream()
                .peek(entity ->
                        entity.setGrade(entity.getGrade() * factor))
                .collect(Collectors.toSet()));
    }

    private Student mapToModel(StudentEntity entity) {
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
