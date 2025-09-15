package zielinskin.springboote2e.restaurant.web;

import org.springframework.web.bind.annotation.*;
import zielinskin.springboote2e.restaurant.api.Pizza;
import zielinskin.springboote2e.restaurant.api.PizzaService;

import java.util.List;

//demonstration of regular bean definition approach
@RestController
@RequestMapping("/pizzas")
class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/{id}")
    public Pizza get(@PathVariable("id") Integer id) {
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
    public void delete(@PathVariable("id") Integer id) {
        pizzaService.delete(id);
    }
}
