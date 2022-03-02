package learn.repository.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoClientConfiguration {

    public static final String DB_URL = "???";

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(DB_URL);
    }

}
