package com.qakmak.eshop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;
import java.util.LinkedList;

/**
 * swagger2
 * @author tapakkur
 * @date 2019/2/16
 */
@Configuration // 配置
@EnableSwagger2 // 让swagger启动
public class SwaggerConfiguration {

    private static Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);

    @Bean
    public Docket swaggerSpringfoxDocket() {
        logger.info("Starting Swagger");
        StopWatch watch = new StopWatch();
        watch.start();
        ApiInfo apiInfo = new ApiInfo(
                "qakmak online e-shop",
                "qakmak 在线购物商城",
                "1.0",
                null,
                null,
                null,
                null,
                new LinkedList<>());

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .forCodeGeneration(true)
                .enable(true)
                .genericModelSubstitutes(ResponseEntity.class)
                .ignoredParameterTypes(java.sql.Date.class)
                .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
                .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
                .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
                .select()
                // 别忘了修改基础包路径
                .apis(RequestHandlerSelectors.basePackage("com.qakmak.eshop.controller"))
                .paths(PathSelectors.any())
                .build();
        watch.stop();
        logger.info("Started Swagger in {} ms", watch.getTotalTimeMillis());
        return docket;
    }
}
