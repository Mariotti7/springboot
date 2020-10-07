package com.servico.global;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}
	
	private ApiInfo apiInfo() {

	        ApiInfo apiInfo = new ApiInfoBuilder()
	                .title ("API de Teste")
	                .description ("Essa é uma API de desenvolvida para testes.")
	                .license("Apache License Version 2.0")
	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	                .termsOfServiceUrl("/service.html")
	                .version("1.0.0")
	                .contact(new Contact("TJF","tjf.totvs.com.br", "teste@totvs.com.br"))
	                .build();

	        return apiInfo;
	    }
	 @ApiOperation(value = "Exclui uma configuração", notes = "Este endpoint exclui uma configuração de email")
	 @ApiResponses({
	     @ApiResponse(code = 204, message = "Exclusão efetuada com sucesso")
	 })
	 @DeleteMapping(path = "/{applicationId}")
	 public void deleteConfig(@PathVariable String applicationId) {

	 }
	 @ApiModelProperty(notes = "Mail server domain", required = true)
	 @NotNull
	 private String domain;
}