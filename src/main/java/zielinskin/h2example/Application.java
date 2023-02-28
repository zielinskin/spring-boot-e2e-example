package zielinskin.h2example;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EntityScan(basePackages={"zielinskin.h2example.data"})
@EnableJpaRepositories(basePackages = {"zielinskin.h2example.data"})
public class Application implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api", "/swagger-ui.html");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



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
