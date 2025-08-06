package zielinskin.springboote2e.restaurant.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages={"zielinskin.springboote2e.restaurant.data"})
@EnableJpaRepositories(basePackages = {"zielinskin.springboote2e.restaurant.data"})
public class RestaurantConfiguration {
    @Bean
    public GroupedOpenApi pizzaDockets() {
        return GroupedOpenApi.builder()
                .group("Pizzas")
                .pathsToMatch("/pizzas/**")
                .build();
    }

    @Bean
    public GroupedOpenApi pastaDocket() {
        return GroupedOpenApi.builder()
                .group("Pastas")
                .pathsToMatch("/pastas/**")
                .build();
    }
}
