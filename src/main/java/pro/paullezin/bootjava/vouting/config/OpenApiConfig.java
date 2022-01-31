package pro.paullezin.bootjava.vouting.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//https://sabljakovich.medium.com/adding-basic-auth-authorization-option-to-openapi-swagger-documentation-java-spring-95abbede27e9
        @SecurityScheme(
                name = "basicAuth",
                type = SecuritySchemeType.HTTP,
                scheme = "basic"
        )
@OpenAPIDefinition(
                info = @Info(
                        title = "REST API documentation",
                        version = "1.0",
                        description = "Приложение BootJava</a>",
                        contact = @Contact(url = "https://localhost:8080/api", name = "admin", email = "admin@gmail.com")
                ),
                security = @SecurityRequirement(name = "basicAuth")
        )
public class OpenApiConfig {

    @Bean
    public GroupedOpenApi api(){
        return GroupedOpenApi.builder()
                .group("REST API")
                .pathsToMatch("/api/**")
                .packagesToExclude("/api/profile/**")
                .build();
    }
}