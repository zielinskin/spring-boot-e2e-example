package zielinskin.springboote2e.school.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages={"zielinskin.springboote2e.school.data"})
@EnableJpaRepositories(basePackages = {"zielinskin.springboote2e.school.data"})
class SchoolInstrumentationConfiguration {
    @Bean
    public GroupedOpenApi studentDocket() {
        return GroupedOpenApi.builder()
                .group("Students")
                .pathsToMatch("/students/**")
                .build();
    }

    @Bean
    public GroupedOpenApi lectureDockets() {
        return GroupedOpenApi.builder()
                .group("Lectures")
                .pathsToMatch("/lectures/**")
                .build();
    }
}
