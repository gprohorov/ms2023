package edu.pro.ms2023.configuration;
/*
  @author   george
  @project   ms2023
  @class  SwaggerConfig
  @version  1.0.0 
  @since 25.09.23 - 13.30
*/

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Docs for MS",
                description = "Swagger module ",
                version = "1.0",
                contact = @Contact(
                        name = "George",
                        email = "my@email.edu",
                        url = "chnu.edu.org"
                )
        )
)
public class SwaggerConfig {
}
