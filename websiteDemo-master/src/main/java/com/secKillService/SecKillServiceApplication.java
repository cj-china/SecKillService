
package com.secKillService;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lasttime.lasttime.dao")
public class SecKillServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecKillServiceApplication.class, args);

    }
}
