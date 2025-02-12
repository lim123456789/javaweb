package kr.co.zerock.api01.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Configuration
//@SecurityScheme(
//        name = "Authorization",
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer",
//        bearerFormat = "JWT"
//)
//@EnableWebSecurity
public class SwaggerConfig {

//    @Bean
//    public GroupedOpenApi adminApi() {
//        return GroupedOpenApi.builder()
//                .group("springshop-admin")
//                .packagesToScan("kr.co.zerock.api01")
//                .build();
//    }
//    @Operation(summary = "rest")
//    @Bean
//    public GroupedOpenApi restAPI() {
//        return GroupedOpenApi.builder()
//                .group("REST API")
//                .pathsToMatch("/**")
//                .pathsToExclude("/api/**")
//                .build();
//    }
//
//    @Operation(summary = "common")
//    @Bean
//    public GroupedOpenApi commonAPI() {
//        return GroupedOpenApi.builder()
//                .group("common API")
//                .pathsToMatch("/controller/**")
//                .build();
//    }



//    @Bean
//    public Docket api(){
//        return new Docket(DocumentationType.OAS_30)
//                .useDefaultResponseMessages(false)
//                .select()
//                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(List.of(apiKey()))
//                .securityContexts(List.of(securityContext()))
//                .apiInfo(apiInfo());
//    }
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("Boot API 01 Project Swagger")
//                .build();
//    }
//
//    private ApiKey apiKey(){
//        return new ApiKey("Authorization", "Bearer Token", "header");
//    }
//
//    private SecurityContext securityContext(){
//        return SecurityContext.builder().securityReferences(defaultAuth())
//                .operationSelector(selector -> selector.requestMappingPattern().startsWith("/api/")).build();
//    }
//
//    private List<SecurityReference> defaultAuth(){
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "global access");
//
//        return List.of(new SecurityReference("Authorization", new AuthorizationScope[]{authorizationScope}));
//    }

    @Bean
    public OpenAPI api() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("Authorization", new SecurityScheme()
                                .type(SecurityScheme.Type.APIKEY)
                                .in(SecurityScheme.In.HEADER)
                                .name("Authorization")
                        ))
                .addSecurityItem(new SecurityRequirement()
                        .addList("Authorization"))
                .info(new Info()
                        .title("Boot API 01 Project Swagger")
                        .version("1.0.0"));
    }

    @Bean
    public GroupedOpenApi restApi() {
        return GroupedOpenApi.builder()
                .group("rest-api")
                .pathsToMatch("/api/**")
                .build();
    }
}
