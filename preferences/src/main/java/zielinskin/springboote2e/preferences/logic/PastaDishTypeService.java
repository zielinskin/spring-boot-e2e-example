package zielinskin.springboote2e.preferences.logic;

import org.springframework.stereotype.Service;
import zielinskin.springboote2e.preferences.api.Dish;
import zielinskin.springboote2e.restaurant.api.PastaService;

import static zielinskin.springboote2e.preferences.api.Dish.PASTA_DISH_TYPE;

@Service
class PastaDishTypeService extends UnderlyingDishTypeService {
    private final PastaService pastaService;
    private final DishMapper dishMapper;

    public PastaDishTypeService(PastaService pastaService,
                                DishMapper dishMapper) {
        super(PASTA_DISH_TYPE);
        this.pastaService = pastaService;
        this.dishMapper = dishMapper;
    }

    @Override
    public Dish getResolvedDish(Integer dishId) {
        return pastaService.get(dishId)
                .map(dishMapper::mapToDish)
                .orElseGet(() ->
                        new Dish(dishId,
                                PASTA_DISH_TYPE,
                                "Not Found!"));
    }
}
