package com.lyh.moqingnavigation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class MoqingNavigationApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoqingNavigationApplication.class, args);
    }

}
