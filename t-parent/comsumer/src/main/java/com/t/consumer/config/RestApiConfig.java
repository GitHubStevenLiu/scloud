package com.t.consumer.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/25 0025 16:54
 */
@Configuration
@EnableSwagger2
//@EnableWebMvc
public class RestApiConfig  implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    protected boolean getTokenParam() {
        return true;
    }
    @Bean
    public Docket commonDocket() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();

        if (getTokenParam()) {
            tokenPar.name("x-access-token").description("令牌").modelRef(new ModelRef("string"))
                    .parameterType("header").required(false).build();
            pars.add(tokenPar.build());
        }

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("通用API接口文档")
                .apiInfo(apiInfo("测试环境通用接口"))
                .securitySchemes(Lists.newArrayList(apiKey()))
                .pathMapping("/")
                .securityContexts( Arrays.asList(securityContext())).select()

                .apis(RequestHandlerSelectors.basePackage("com.t.consumer.controller"))//指向自己的controller即可
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);


    }
    private ApiKey apiKey() {
        return new ApiKey("Authorization", "api_key", "header");
    }
    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/")).build();
    }
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope =
                new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return  Arrays.asList(new SecurityReference("Authorization", authorizationScopes));
    }
    private ApiInfo apiInfo(String desc) {
        return new ApiInfoBuilder()
                //页面标题
                .title(desc)
                //版本号
                .contact("123")
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

}
