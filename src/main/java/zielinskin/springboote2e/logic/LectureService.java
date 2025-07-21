package zielinskin.springboote2e.logic;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import zielinskin.springboote2e.data.LectureEntity;
import zielinskin.springboote2e.data.LectureRepository;
import zielinskin.springboote2e.data.StudentEntity;
import zielinskin.springboote2e.view.Lecture;
import zielinskin.springboote2e.view.Student;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LectureService {
    private final LectureRepository lectureRepository;
    private final LectureMapper lectureMapper;

    public LectureService(LectureRepository lectureRepository,
                          LectureMapper lectureMapper) {
        this.lectureRepository = lectureRepository;
        this.lectureMapper = lectureMapper;
    }

    @Transactional
    public void save(Lecture lecture) {
        lectureRepository.save(lectureMapper.mapToEntity(lecture));
    }

    public List<Lecture> getAll() {
        return lectureRepository.findAll().stream()
                .map(lectureMapper::mapToView)
                .collect(Collectors.toList());
    }
}
