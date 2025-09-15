package zielinskin.springboote2e.preferences.logic;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import zielinskin.springboote2e.preferences.api.Dish;
import zielinskin.springboote2e.restaurant.api.Pasta;
import zielinskin.springboote2e.restaurant.api.Pizza;

@Mapper(componentModel = "spring")
interface DishMapper {
    @Mapping(target = "dishType", constant = "1")
    Dish mapToDish(Pasta pasta);

    @Mapping(target = "dishType", constant = "2")
    @Mapping(source = "pizza", target = "name", qualifiedByName = "pizzaToName")
    Dish mapToDish(Pizza pizza);

    @Named("pizzaToName")
    static String getName(Pizza pizza) {
        return String.format("%s:%s:%d",
                pizza.getType(),
                pizza.getCrust(),
                pizza.getSize());
    }
}
