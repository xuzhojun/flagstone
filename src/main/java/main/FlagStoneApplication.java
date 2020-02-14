package main;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("controller,service.impl")
@MapperScan("dao")
public class FlagStoneApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlagStoneApplication.class, args);
    }
}
