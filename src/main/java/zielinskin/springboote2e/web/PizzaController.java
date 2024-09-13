package zielinskin.springboote2e.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import zielinskin.springboote2e.exception.NotFoundException;
import zielinskin.springboote2e.logic.PizzaService;
import zielinskin.springboote2e.view.Pizza;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/{id}")
    public Pizza get(@PathVariable Integer id) {
        if(id < 1) {
            throw new RuntimeException("Invalid pizza id");
        }
        return pizzaService.get(id)
                .orElseThrow(NotFoundException::new);
    }


    @GetMapping("/errors/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void throw404() {

    }


    @GetMapping("/errors/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void throw401() {

    }


    @GetMapping("/errors/403")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void throw403() {

    }

    @GetMapping("/errors/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void throw500() {

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
