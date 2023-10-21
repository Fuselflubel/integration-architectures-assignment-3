package de.hbrs.ia;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class SpringStartup {
    public static void main(String[] args) {
        SpringApplication.run(SpringStartup.class, args);
    }

    // inject mongodb
    @Bean
    public MongoDatabase database() {
        return MongoClients.create("mongodb://localhost:27017").getDatabase("salesman");
    }
}
