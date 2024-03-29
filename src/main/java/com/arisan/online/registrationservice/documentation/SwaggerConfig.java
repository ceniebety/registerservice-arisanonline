package com.arisan.online.registrationservice.documentation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Register Service of Arisan Online Rest API")
				.description(
						"Register Service List of Arisan Online Rest API ")
				.termsOfServiceUrl("").version("0.0.1-SNAPSHOT")
				.contact(new Contact("Cenie Bety Greditasari",null,null)).build();
	}

	@Bean
	public Docket configureControllerPackageAndConvertors() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.arisan.online.registrationservice.controller")).build()
	                .apiInfo(apiInfo());
	}
}
