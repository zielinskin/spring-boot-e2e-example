package zielinskin.springboote2e.preferences.logic;

import org.springframework.stereotype.Service;
import zielinskin.springboote2e.preferences.api.Dish;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Service
class DishService {
    private final List<UnderlyingDishTypeService> dishTypeServices;

    public DishService(List<UnderlyingDishTypeService> dishTypeServices) {
        this.dishTypeServices = dishTypeServices;
    }

    public Dish getDish(Integer id, Integer dishTypeId) {
        return dishTypeServices.stream()
                .filter(service ->
                        Objects.equals(dishTypeId, service.getDishTypeId()))
                .findFirst()
                .map(service ->
                        service.getResolvedDish(id))
                .orElseThrow(NoSuchElementException::new);
    }
}
