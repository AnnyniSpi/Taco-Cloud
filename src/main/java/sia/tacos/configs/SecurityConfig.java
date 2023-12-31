package sia.tacos.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import sia.tacos.model.User;
import sia.tacos.repositories.UserRepository;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests()
                .requestMatchers("/design", "/orders").hasRole("USER")
                .requestMatchers("/", "/**")
                .permitAll()
//                .requestMatchers(HttpMethod.OPTIONS).permitAll()
//                .requestMatchers(HttpMethod.POST, "/api/ingredients")
//                .hasAuthority("SCOPE_writeIngredients")
//                .requestMatchers(HttpMethod.DELETE, "/api//ingredients")
//                .hasAuthority("SCOPE_deleteIngredients")
//                .requestMatchers("/api//tacos", "/api//orders/**")
//                .permitAll()
//                .requestMatchers("/**")
//                .permitAll()
//                .and()
//                .oauth2ResourceServer(oauth2 -> oauth2.jwt())

//                .httpBasic()
//                .realmName("Taco Cloud")

                .and()
                .formLogin()
                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/design")

                .and()
                .oauth2Login()
                .loginPage("/login")

                .and()
                .logout()
                .logoutSuccessUrl("/")

                .and()
                .build();
    }

}
