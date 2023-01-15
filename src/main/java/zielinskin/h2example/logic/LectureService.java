package zielinskin.h2example.logic;

import org.springframework.stereotype.Service;
import zielinskin.h2example.data.LectureEntity;
import zielinskin.h2example.data.LectureRepository;
import zielinskin.h2example.data.StudentEntity;
import zielinskin.h2example.view.Lecture;
import zielinskin.h2example.view.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;

    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public void save(Lecture lecture) {
        lectureRepository.save(mapToEntity(lecture));
    }

    public List<LectureEntity> getAll() {
        return lectureRepository.findAll();
    }
    public Lecture get(Integer id) {
        return lectureRepository.findById(id)
                .map(this::mapToModel)
                .orElseThrow(() ->
                        new RuntimeException("There wasn't one, duh."));
    }

    private LectureEntity mapToEntity(Lecture lecture) {
        LectureEntity entity = new LectureEntity();

        entity.setId(lecture.getId());
        entity.setName(lecture.getName());
        entity.setStudents(lecture.getStudents().stream()
                .map(e -> {
                    StudentEntity studentEntity = mapToEntity(e, entity);
                    entity.getStudents().add(studentEntity);
                    return studentEntity;
                })
                .collect(Collectors.toSet()));
        return entity;
    }

    private StudentEntity mapToEntity(Student view, LectureEntity lectureEntity) {
        StudentEntity entity = new StudentEntity();

        entity.setLecture(lectureEntity);
        entity.setGrade(view.getGrade());
        entity.setName(view.getName());
        entity.setId(view.getId());
        return entity;
    }
    private Lecture mapToModel(LectureEntity entity) {
        return new Lecture(entity.getId(),
                entity.getName(),
                entity.getStudents().stream()
                        .map(sEntity ->{
                            return new Student(sEntity.getId(),
                                    sEntity.getName(),
                                    sEntity.getGrade());
                        })
                        .collect(Collectors.toSet()));
    }
}
