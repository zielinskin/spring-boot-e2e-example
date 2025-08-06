package zielinskin.springboote2e.school.web;


import org.springframework.web.bind.annotation.*;
import zielinskin.common.logic.AbstractCrudService;
import zielinskin.common.logic.CrudService;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.school.logic.LectureService;
import zielinskin.springboote2e.school.view.Lecture;

import java.util.List;

@RestController
@RequestMapping("/lectures")
public class LectureController extends AbstractCrudController<Lecture, Integer, LectureService> {
    public LectureController(LectureService service) {
        super(service);
    }
}
