package zielinskin.springboote2e.school.logic;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.school.data.LectureEntity;
import zielinskin.springboote2e.school.view.Lecture;

@Mapper(componentModel = "spring", uses = StudentMapper.class)
public abstract class LectureMapper implements BiMapper<Lecture, LectureEntity> {

    @AfterMapping
    protected void handlePostConstruct(@MappingTarget LectureEntity entity) {
        entity.getStudents()
                .forEach(student ->
                        student.setLecture(entity));
    }
}
