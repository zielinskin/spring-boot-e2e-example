package zielinskin.h2example.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureRepository extends CrudRepository<LectureEntity, Integer> {
    List<LectureEntity> findAll();

}