package zielinskin.springboote2e;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


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


//    @Bean
//    @Order(2)
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
//    @Order(1)
//    public SecurityFilterChain apiLogin(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        http
//                .securityMatcher(AntPathRequestMatcher.antMatcher("/api/**"))
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authorize -> authorize
//                        .anyRequest()
//                        .hasRole("USER")
//                )
//                .userDetailsService(userDetailsService);
//        return http.build();
//    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(UserDetailsManager userDetailsService,
//                                                            PasswordEncoder encoder) {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(encoder);
//        return authProvider;
//    }


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
                .pathsToMatch("/api/pizzas/**")
                .build();
    }


    @Bean
    public GroupedOpenApi clientPizzaDockets() {
        return GroupedOpenApi.builder()
                .group("Pizza Client")
                .pathsToMatch("/api/client-pizzas/**")
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
