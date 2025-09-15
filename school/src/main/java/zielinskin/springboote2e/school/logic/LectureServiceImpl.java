package zielinskin.springboote2e.school.logic;

import org.springframework.stereotype.Service;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.BiMapper;
import zielinskin.springboote2e.school.api.Lecture;
import zielinskin.springboote2e.school.api.LectureService;
import zielinskin.springboote2e.school.data.LectureEntity;
import zielinskin.springboote2e.school.data.LectureRepository;

@Service
class LectureServiceImpl extends AbstractCrudService<LectureEntity, Lecture, Integer, LectureRepository> implements LectureService {
    public LectureServiceImpl(LectureRepository repository,
                              BiMapper<Lecture, LectureEntity> mapper) {
        super(repository, mapper);
    }
}
