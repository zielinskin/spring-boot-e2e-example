package zielinskin.springboote2e.restaurant.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.common.web.AbstractCrudController;
import zielinskin.springboote2e.restaurant.api.Pasta;
import zielinskin.springboote2e.restaurant.api.PastaService;

@RestController
@RequestMapping("/pastas")
class PastaController extends AbstractCrudController<Pasta, Integer, PastaService> {
    public PastaController(PastaService service) {
        super(service);
    }
}