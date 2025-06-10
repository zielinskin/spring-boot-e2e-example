package zielinskin.springboote2e.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
    List<StudentEntity> findAll();
    List<StudentEntity> findByGradeLessThanEqual(Double grade);
}
