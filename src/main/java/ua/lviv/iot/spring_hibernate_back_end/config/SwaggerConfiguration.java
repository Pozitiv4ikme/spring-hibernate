package ua.lviv.iot.spring_hibernate_back_end.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
    private static final String SWAGGER_API_VERSION = "0.1";
    private static final String LICENSE_TEXT = "License by Veres IoT @2022";
    private static final String title = "Spring Boot + Hibernate by Pozitiv4ik_me";
    private static final String description = "I LOVE JAVA";

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title(title)
            .description(description)
            .license(LICENSE_TEXT)
            .version(SWAGGER_API_VERSION)
            .build();
    }

    @Bean
    public Docket decksApi() {
        return new Docket(DocumentationType.OAS_30)
            .apiInfo(apiInfo())
            .pathMapping("/")
            .select()
            .paths(PathSelectors.any())
            .build();
    }
}
