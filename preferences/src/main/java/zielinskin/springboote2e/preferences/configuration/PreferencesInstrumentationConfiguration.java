package zielinskin.springboote2e.preferences.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages={"zielinskin.springboote2e.preferences.data"})
@EnableJpaRepositories(basePackages = {"zielinskin.springboote2e.preferences.data"})
class PreferencesInstrumentationConfiguration {
    @Bean
    public GroupedOpenApi preferencesDocket() {
        return GroupedOpenApi.builder()
                .group("Preferences")
                .pathsToMatch("/preferences/**")
                .build();
    }
}
