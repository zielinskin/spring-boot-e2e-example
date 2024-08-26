package zielinskin.springboote2e.web;


import org.springframework.web.bind.annotation.*;
import zielinskin.springboote2e.logic.LectureService;
import zielinskin.springboote2e.view.Lecture;

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
    public List<Lecture> saveLecture() {
        return lectureService.getAll();
    }
}
