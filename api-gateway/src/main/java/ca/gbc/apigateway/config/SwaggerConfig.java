package ca.gbc.apigateway.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Gateway Documentation")
                        .description("API Gateway Swagger Documentation for all microservices")
                        .version("1.0"));
    }

    @Bean
    public GroupedOpenApi apiGatewayOpenApi() {
        return GroupedOpenApi.builder()
                .group("api-gateway")
                .pathsToMatch("/**")
                .build();
    }
}
