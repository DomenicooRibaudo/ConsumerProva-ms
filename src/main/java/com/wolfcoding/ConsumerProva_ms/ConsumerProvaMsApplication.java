package com.wolfcoding.ConsumerProva_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:beans.xml")
public class ConsumerProvaMsApplication {

    public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        SpringApplication.run(ConsumerProvaMsApplication.class, args);

    }

}
