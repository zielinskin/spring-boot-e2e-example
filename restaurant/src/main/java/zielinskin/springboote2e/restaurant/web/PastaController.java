package zielinskin.springboote2e.restaurant.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.restaurant.logic.PastaService;
import zielinskin.springboote2e.restaurant.view.Pasta;

import java.util.List;

@RestController
@RequestMapping("/pastas")
public class PastaController extends AbstractCrudController<Pasta, Integer, PastaService> {
    public PastaController(PastaService service) {
        super(service);
    }
}