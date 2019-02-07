/*package com.lasttime.lasttime;

import com.lasttime.lasttime.controller.CustomExporter;
import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnablePrometheusEndpoint
public class SpringApplication1 extends WebMvcConfigurerAdapter implements CommandLineRunner {

    @Autowired
    private CustomExporter customExporter;

//省略的代码

    @Override
    public void run(String... args) throws Exception {
    //...省略的代码
        customExporter.register();
    }

}
*/