package com.szmtr.gateway.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public List<GroupedOpenApi> apis() {
        return List.of(GroupedOpenApi.builder().group("auth").pathsToMatch("/auth/**").build(), GroupedOpenApi.builder().group("system").pathsToMatch("/system/**").build(), GroupedOpenApi.builder().group("file").pathsToMatch("/file/**").build(),
                GroupedOpenApi.builder().group("file").pathsToMatch("/gen/**").build()
                // 添加其他微服务分组
        );
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("微服务API文档").version("1.0").description("微服务系统接口文档")).externalDocs(new ExternalDocumentation().description("若依官方文档").url("https://ruoyi.vip"));
    }
}