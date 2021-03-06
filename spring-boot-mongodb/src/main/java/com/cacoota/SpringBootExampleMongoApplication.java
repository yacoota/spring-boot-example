package com.cacoota;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@Slf4j
@SpringBootApplication
public class SpringBootExampleMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleMongoApplication.class, args);
        log.info("-------------------------------------- 应用程序启动完成 --------------------------------------");
    }
}
