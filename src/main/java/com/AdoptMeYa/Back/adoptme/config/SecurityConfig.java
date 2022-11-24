package com.AdoptMeYa.Back.adoptme.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf()
                .disable()
                .formLogin()
                .disable()
                .httpBasic()
                .disable()
                .exceptionHandling()
                .and()
                .authorizeRequests()
                .antMatchers("/",
                        "/error",
                        "/favicon.ico",
                        "/**/*.png",
                        "/**/*.gif",
                        "/**/*.svg",
                        "/**/*.jpg",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/**/*.woff2"
                )
                .permitAll()
                .antMatchers(
                        "/users/login",
                        "/users/signup",
                        "/users/{id}",
                        "/users",
                        "/users/",
                        "/publications",
                        "/publications/",
                        "/publications/{publicationId}",
                        "/pets",
                        "/pets/",
                        "/pets/{id}",
                        "/notifications",
                        "/notifications/",
                        "/notifications/{notificationId}",
                        "/districts",
                        "/districts/",
                        "/districts/{id}",
                        "/advertisements",
                        "/advertisements/",
                        "/advertisements/{advertisementId}",
                        "/v2/api-docs",
                        "/webjars/**",
                        "/swagger-resources/**"
                )
                .permitAll()
                .anyRequest()
                .authenticated()
        ;
        
    }
}
