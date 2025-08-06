package zielinskin.springboote2e.crossinstance.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CrossInstancePropertySource.class)
public class CrossInstanceConfiguration {

    @Bean
    public GroupedOpenApi crossInstanceDocket() {
        return GroupedOpenApi.builder()
                .group("Cross Instance")
                .pathsToMatch("/cross-instance/**")
                .build();
    }
}
