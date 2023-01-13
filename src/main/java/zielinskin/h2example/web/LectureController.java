package zielinskin.h2example.web;


import org.springframework.web.bind.annotation.*;
import zielinskin.h2example.data.LectureEntity;
import zielinskin.h2example.logic.LectureService;
import zielinskin.h2example.view.Lecture;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController {
    private final LectureService lectureService;

    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @PostMapping()
    public void saveLecture(@RequestBody Lecture lecture) {
        lectureService.save(lecture);
    }

    @GetMapping()
    public List<LectureEntity> saveLecture() {
        return lectureService.getAll();
    }
}
