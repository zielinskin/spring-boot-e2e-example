package zielinskin.springboote2e;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.task.ThreadPoolTaskSchedulerBuilder;
import org.springframework.boot.task.ThreadPoolTaskSchedulerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.ErrorHandler;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

//import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
@EntityScan(basePackages={"zielinskin.springboote2e.data"})
@EnableJpaRepositories(basePackages = {"zielinskin.springboote2e.data"})
//@EnableWebSecurity
public class Application implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/jsp/");
        bean.setSuffix(".jsp");
        return bean;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(viewResolver());
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/api", "/swagger-ui.html");
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public UserDetailsManager userDetailsManager(PasswordEncoder encoder) {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//
//        manager.createUser(User.builder()
//                .passwordEncoder(encoder::encode)
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build());
//        manager.createUser(User.builder()
//                .passwordEncoder(encoder::encode)
//                .username("admin")
//                .password("alsoAdmin")
//                .roles("USER", "ADMIN")
//                .build());
//        return manager;
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }


    /* will uncomment when swapping to jdbc details service
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        UserDetails user = User.builder()
                .passwordEncoder(new BCryptPasswordEncoder()::encode)
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails admin = User.builder()
                .passwordEncoder(new BCryptPasswordEncoder()::encode)
                .username("admin")
                .password("alsoAdmin")
                .roles("USER", "ADMIN")
                .build();
        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
        users.createUser(user);
        users.createUser(admin);
        return users;
    }*/

//
//    @Bean
//    public SecurityFilterChain formLoginFilterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest()
//                        .hasRole("USER")
//                )
//                .userDetailsService(userDetailsService)
//                .formLogin(withDefaults());
//        return http.build();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(UserDetailsManager userDetailsService,
//                                                            PasswordEncoder encoder) {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder);
//        return authProvider;
//    }

    @Bean
    public GroupedOpenApi fileFix() {
        return GroupedOpenApi.builder()
                .group("File Fix")
                .pathsToMatch("/fixFiles")
                .build();
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

    @Bean
    public GroupedOpenApi testDocket() {
        return GroupedOpenApi.builder()
                .group("Testing")
                .pathsToMatch("/test/**")
                .build();
    }
}
