package org.studyeasy.SpringBlog.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
    private static final String[] WHITELIST = {
            "/",
            "/login",
            "/register",
            "/db-console/**",
            "/resources/**",
            "/posts/**",
            "/forgot-password",
            "/reset-password/**"
    };


    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .requestMatchers(WHITELIST).permitAll()
                .requestMatchers("/profile/**").authenticated()
                .requestMatchers("/profile/**").authenticated()
                .requestMatchers("/update_photo/**").authenticated()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/editor/**").hasAnyRole("ADMIN", "EDITOR")
                .and()
                .formLogin()
                .loginPage("/login").loginProcessingUrl("/login")
                .usernameParameter("email").passwordParameter("password")
                .defaultSuccessUrl("/", true).failureUrl("/login?error")
                .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .rememberMe().rememberMeParameter("remember-me")
                .and()
                .httpBasic();

        // TODO: remove these after upgrading the DB from H2 infile DB
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}


