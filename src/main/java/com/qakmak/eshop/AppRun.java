package com.qakmak.eshop;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * created by tapakkur on 2019/2/15
 */
@EnableSwagger2
@SpringBootApplication
@ComponentScan(basePackages = {"com.qakmak.eshop"})
@MapperScan(value = "com.qakmak.eshop.dao")
public class AppRun implements CommandLineRunner {

//    输出日志信息
    private static Logger logger = LoggerFactory.getLogger(AppRun.class);

    public static void main(String[] args) {

        SpringApplication.run(AppRun.class, args);

    }

    // 重写 CommandLineRunner 接口类的 run()方法
    @Override
    public void run(String... args) throws Exception {
        logger.info("服务已启动...");
    }
}
