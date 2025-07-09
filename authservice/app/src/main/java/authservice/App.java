package authservice;

import authservice.auth.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"authservice.repository"})
@ComponentScan(basePackages = {"authservice.controller", "authservice.auth", "authservice.service",
        "authservice.eventProducer", "authservice.config"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}