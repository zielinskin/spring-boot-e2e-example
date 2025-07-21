package zielinskin.springboote2e.logic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import zielinskin.springboote2e.data.StudentEntity;
import zielinskin.springboote2e.view.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    @Mapping(target = "lecture", ignore = true)
    StudentEntity mapToEntity(Student view);
    Student mapToView(StudentEntity entity);
}
