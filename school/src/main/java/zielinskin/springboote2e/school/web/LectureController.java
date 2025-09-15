package zielinskin.springboote2e.school.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.school.api.Lecture;
import zielinskin.springboote2e.school.api.LectureService;

@RestController
@RequestMapping("/lectures")
public class LectureController extends AbstractCrudController<Lecture, Integer, LectureService> {
    public LectureController(LectureService service) {
        super(service);
    }
}