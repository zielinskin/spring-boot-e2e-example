package zielinskin.springboote2e.preferences.api;

public record Dish(Integer id, Integer dishType, String name) {
    public static final Integer PASTA_DISH_TYPE = 1;
    public static final Integer PIZZA_DISH_TYPE = 2;

}
