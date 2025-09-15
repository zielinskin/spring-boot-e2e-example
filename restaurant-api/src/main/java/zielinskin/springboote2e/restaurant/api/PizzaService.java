package zielinskin.springboote2e.restaurant.api;

import java.util.List;
import java.util.Optional;

public interface PizzaService {
    Optional<Pizza> get(Integer id);
    List<Pizza> get();
    void save(Pizza view);
    void delete(Integer id);
}
