package zielinskin.springboote2e.school.logic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.school.api.Student;
import zielinskin.springboote2e.school.data.StudentEntity;

@Mapper(componentModel = "spring")
interface StudentMapper extends BiMapper<Student, StudentEntity> {
    @Mapping(target = "lecture", ignore = true)
    StudentEntity mapToEntity(Student view);
}
