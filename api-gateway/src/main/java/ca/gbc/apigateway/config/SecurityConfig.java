package ca.gbc.apigateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.server.WebFilter;
import reactor.core.publisher.Mono;

@Configuration
public class SecurityConfig {

    @Bean
    public WebFilter securityWebFilter() {
        return (exchange, chain) -> {
            String path = exchange.getRequest().getPath().value();
            if (path.startsWith("/swagger-ui") || path.startsWith("/v3/api-docs")) {
                return chain.filter(exchange);
            }
            return chain.filter(exchange);
        };
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails user = User.builder()
                .username("user")
                .password(encoder.encode("password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
