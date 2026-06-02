package zielinskin.springboote2e.restaurant.api;

import java.util.List;
import java.util.Optional;

public interface DrinkService {
    Optional<Drink> get(Integer id);
    List<Drink> get();
    void save(Drink view);
    void delete(Integer id);
}
