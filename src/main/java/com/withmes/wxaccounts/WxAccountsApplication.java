package com.withmes.wxaccounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WxAccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WxAccountsApplication.class, args);

        System.out.println(1234);
    }
}
