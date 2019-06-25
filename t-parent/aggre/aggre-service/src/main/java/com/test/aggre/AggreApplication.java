package com.test.aggre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Description:
 * @author: liuyang
 * @datetime: 2019/6/21 0021 16:13
 */

@SpringBootApplication
@EnableDiscoveryClient
public class AggreApplication {

    public static void main(String[] args) {
        SpringApplication.run(AggreApplication.class, args);
    }

}
