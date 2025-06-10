package zielinskin.springboote2e.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.springboote2e.view.DateRequest;

@RestController
@RequestMapping("/test/dates")
public class DateTestController {

    @PostMapping("/")
    public DateRequest getRequest(@RequestBody DateRequest request) {
        return request;
    }
}
