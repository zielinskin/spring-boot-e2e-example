package zielinskin.springboote2e.school.logic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.school.data.StudentEntity;
import zielinskin.springboote2e.school.view.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BiMapper<Student, StudentEntity> {
    @Mapping(target = "lecture", ignore = true)
    StudentEntity mapToEntity(Student view);
}
