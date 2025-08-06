package zielinskin.springboote2e.school.logic;

import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.school.data.LectureEntity;
import zielinskin.springboote2e.school.data.LectureRepository;
import zielinskin.springboote2e.school.view.Lecture;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService extends AbstractCrudService<LectureEntity, Lecture, Integer, LectureRepository> {
    public LectureService(LectureRepository repository,
                          BiMapper<Lecture, LectureEntity> mapper) {
        super(repository, mapper);
    }
}
