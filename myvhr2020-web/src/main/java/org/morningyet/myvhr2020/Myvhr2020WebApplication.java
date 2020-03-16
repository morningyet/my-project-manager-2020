package org.morningyet.myvhr2020;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "org.morningyet.myvhr2020.dao" )
public class Myvhr2020WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Myvhr2020WebApplication.class, args);
    }

}
