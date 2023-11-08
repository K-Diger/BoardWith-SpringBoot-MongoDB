package com.diger.notonlysqlboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class NotOnlySqlBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotOnlySqlBoardApplication.class, args);
    }
}
