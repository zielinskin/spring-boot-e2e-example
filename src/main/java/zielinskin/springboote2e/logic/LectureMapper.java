package zielinskin.springboote2e.logic;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import zielinskin.springboote2e.data.LectureEntity;
import zielinskin.springboote2e.view.Lecture;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public abstract class LectureMapper {
    abstract LectureEntity mapToEntity(Lecture view);
    abstract Lecture mapToView(LectureEntity entity);

    @AfterMapping
    protected void handlePostConstruct(@MappingTarget LectureEntity entity) {
        entity.getStudents()
                .forEach(student ->
                        student.setLecture(entity));
    }
}
