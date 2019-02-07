
package com.lasttime.lasttime;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lasttime.lasttime.dao")
public class LasttimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(LasttimeApplication.class, args);

    }
}
