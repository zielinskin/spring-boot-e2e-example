package zielinskin.springboote2e.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.springboote2e.logic.CrossInstanceService;
import zielinskin.springboote2e.view.Pasta;

import java.util.List;

@RestController
@RequestMapping("cross-instance")
public class CrossInstanceController {
    private final CrossInstanceService crossInstanceService;

    public CrossInstanceController(CrossInstanceService crossInstanceService) {
        this.crossInstanceService = crossInstanceService;
    }

    @RequestMapping("/cross-calls/${numberOfCalls}")
    public List<Pasta> getInstances(@PathVariable("numberOfCalls") Integer numberOfCalls) {
        return crossInstanceService.getInstanceList(numberOfCalls);
    }
}
