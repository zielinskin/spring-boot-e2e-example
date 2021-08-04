package zielinskin.h2example.logic;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.data.StudentRepository;
import zielinskin.h2example.model.Student;

import java.util.List;
import java.util.Optional;
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

    private Student mapToModel(StudentEntity entity) {
        return new Student(entity.getId(), entity.getName());
    }

    private StudentEntity mapToEntity(Student model) {
        StudentEntity entity = Optional.ofNullable(model.getId())
                .flatMap(studentRepository::findById)
                .orElse(new StudentEntity());

        entity.setName(model.getName());

        return entity;
    }
}
