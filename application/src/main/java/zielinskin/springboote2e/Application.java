package zielinskin.springboote2e;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


@SpringBootApplication
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
}
