package zielinskin.h2example.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.h2example.logic.PastaService;
import zielinskin.h2example.view.Pasta;
import zielinskin.h2example.view.Pizza;

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