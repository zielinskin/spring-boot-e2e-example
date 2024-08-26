package zielinskin.springboote2e.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.springboote2e.logic.PastaService;
import zielinskin.springboote2e.view.Pasta;

import java.util.List;

@RestController
@RequestMapping("/pastas")
public class PastaController {
    private final PastaService pastaService;

    public PastaController(PastaService pastaService) {
        this.pastaService = pastaService;
    }

    @GetMapping("/{id}")
    public Pasta get(@PathVariable Integer id) {
        return pastaService.get(id)
                .orElse(null);
    }

    @GetMapping()
    public List<Pasta> get() {
        return pastaService.get();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody Pasta pizza) {
        pastaService.save(pizza);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pastaService.delete(id);
    }
}