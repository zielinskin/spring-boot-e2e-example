package zielinskin.springboote2e.preferences.logic;

import zielinskin.springboote2e.preferences.api.Dish;

public abstract class UnderlyingDishTypeService {
    private final Integer dishTypeId;

    public UnderlyingDishTypeService(Integer dishTypeId) {
        this.dishTypeId = dishTypeId;
    }

    public Integer getDishTypeId() {
        return dishTypeId;
    }

    public abstract Dish getResolvedDish(Integer dishId);
}
