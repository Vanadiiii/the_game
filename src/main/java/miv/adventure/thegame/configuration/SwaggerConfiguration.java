package miv.adventure.thegame.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public OpenAPI gameOpenApi() {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("The great game!")
                                .version("1.0.0")
                                .contact(
                                        new Contact()
                                                .email("vanadiiii42@gmail.com")
                                                .name("Ivan Matveev")
                                )
                );
    }
}
