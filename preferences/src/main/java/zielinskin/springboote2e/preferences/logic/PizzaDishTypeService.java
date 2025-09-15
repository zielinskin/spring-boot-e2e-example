package zielinskin.springboote2e.preferences.logic;

import org.springframework.stereotype.Service;
import zielinskin.springboote2e.preferences.api.Dish;
import zielinskin.springboote2e.restaurant.api.PizzaService;

import static zielinskin.springboote2e.preferences.api.Dish.PIZZA_DISH_TYPE;

@Service
class PizzaDishTypeService extends UnderlyingDishTypeService {
    private final PizzaService pizzaService;
    private final DishMapper dishMapper;

    public PizzaDishTypeService(PizzaService pizzaService,
                                DishMapper dishMapper) {
        super(PIZZA_DISH_TYPE);
        this.pizzaService = pizzaService;
        this.dishMapper = dishMapper;
    }

    @Override
    public Dish getResolvedDish(Integer dishId) {
        return pizzaService.get(dishId)
                .map(dishMapper::mapToDish)
                .orElseGet(() ->
                        new Dish(dishId,
                                PIZZA_DISH_TYPE,
                                "Not Found!"));
    }
}
