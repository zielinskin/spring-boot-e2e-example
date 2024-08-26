package zielinskin.springboote2e.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zielinskin.springboote2e.logic.PastaService;

@Controller
public class PastaMVController {
    private final PastaService pastaService;

    public PastaMVController(PastaService pastaService) {
        this.pastaService = pastaService;
    }

    @RequestMapping("/pasta")
    public ModelAndView viewPastas(ModelAndView model) {

        model.setViewName("pasta");
        model.addObject("pastas", pastaService.get());
        return model;
    }
}
