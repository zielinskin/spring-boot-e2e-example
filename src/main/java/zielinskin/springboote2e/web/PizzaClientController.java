package zielinskin.springboote2e.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zielinskin.springboote2e.logic.PizzaClientService;
import zielinskin.springboote2e.view.Pizza;

@RestController
@RequestMapping("/api")
class PizzaClientController {
    private final PizzaClientService pizzaClientService;

    public PizzaClientController(PizzaClientService pizzaClientService) {
        this.pizzaClientService = pizzaClientService;
    }

    @GetMapping("/client-pizzas/{id}")
    public Pizza getById(@PathVariable int id) {
        return pizzaClientService.getById(id);
    }


    @GetMapping("/client-pizzas/errors/{id}")
    public String getById(@PathVariable Integer id) {
        return pizzaClientService.throwError(id);
    }
}
