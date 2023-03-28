package zielinskin.h2example.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.h2example.logic.PizzaService;
import zielinskin.h2example.view.Pizza;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/{id}")
    public Pizza get(@PathVariable Integer id) {
        return pizzaService.get(id)
                .orElse(null);
    }

    @GetMapping()
    public List<Pizza> get() {
        return pizzaService.get();
    }

    @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    public void save(@RequestBody Pizza pizza) {
        pizzaService.save(pizza);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        pizzaService.delete(id);
    }
}
