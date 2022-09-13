package com.webbApp.GoalQuest.Security;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.ui.ModelMap;

import java.util.function.Function;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SpringSecurityConfiguration {


        @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {


          UserDetails userDetails1 = createNewUser("Delphi", "Ilovekibble");
            UserDetails userDetails2 = createNewUser("lilB", "nub4life");

            return new InMemoryUserDetailsManager(userDetails1, userDetails2);
        }
    private UserDetails createNewUser(String userName, String password) {
        Function<String, String> passwordEncoder
                = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(userName)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
    public SecurityFilterChain filterChain( HttpSecurity http) throws Exception {
            http.authorizeHttpRequests(
//                    auth -> auth.anyRequest().authenticated());
                    auth -> auth.antMatchers("/createUser").permitAll()
                            .antMatchers("/", "/goals", "/updateGoal","/addSubGoal").authenticated()
//                            .anyRequest().authenticated()
                            );
//              default login page for Spring.
//            http.formLogin(withDefaults());


            http.formLogin(form -> form
                            .loginPage("/login").permitAll()
                            .defaultSuccessUrl("/")
                            .failureUrl("/login")
            );

            http.logout().logoutSuccessUrl("/login");

            http.csrf().disable();
            http.headers().frameOptions().disable();
            return http.build();
        }
}
