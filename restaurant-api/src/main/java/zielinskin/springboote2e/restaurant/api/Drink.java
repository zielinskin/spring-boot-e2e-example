package zielinskin.springboote2e.restaurant.api;

public record Drink(Integer id,
                    String name,
                    Integer carbonationScale,
                    Boolean ageRestricted) {
}
