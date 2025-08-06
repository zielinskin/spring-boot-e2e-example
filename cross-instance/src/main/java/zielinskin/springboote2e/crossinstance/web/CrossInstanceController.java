package zielinskin.springboote2e.crossinstance.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.springboote2e.crossinstance.logic.CrossInstanceService;
import zielinskin.springboote2e.crossinstance.view.DataHoldingRecord;

import java.util.List;

@RestController
@RequestMapping("cross-instance")
public class CrossInstanceController {
    private final CrossInstanceService crossInstanceService;

    public CrossInstanceController(CrossInstanceService crossInstanceService) {
        this.crossInstanceService = crossInstanceService;
    }

    @GetMapping("/cross-calls/{numberOfCalls}")
    public List<DataHoldingRecord> getInstances(@PathVariable("numberOfCalls") Integer numberOfCalls) {
        return crossInstanceService.getInstanceList(numberOfCalls);
    }
}
