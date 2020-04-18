package com.cacoota;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Slf4j
@SpringBootApplication
@MapperScan("com.cacoota.*.mapper")
@EnableTransactionManagement
public class SpringBootExamplMysqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootExamplMysqlApplication.class, args);
        log.info("-------------------------------------- 应用程序启动完成 --------------------------------------");
    }
}
