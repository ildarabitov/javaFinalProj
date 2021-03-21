package ru.stud.minibankgateway.config;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class MiniBankGatewayConfig {
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    @Bean
    public Docket swaggerConfiguration(){
return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("ru.stud.minibankgateway"))
        .build()
        .apiInfo(apiDetails());
    }
    private ApiInfo apiDetails(){
        return new ApiInfo(
               "Mini - Bank API",
                "Sample API for connect Mini - Bank Gateway",
                "1.0",
                "Free to use",
                new Contact("Abitov Ildar","http://stud.ru","a@b.ru"),
                "API License",
                "http://stud.ru",
                Collections.emptyList());

    }
}
