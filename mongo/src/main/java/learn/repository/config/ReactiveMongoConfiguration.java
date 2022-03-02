package learn.repository.config;

import com.mongodb.reactivestreams.client.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@Lazy
@Configuration
@EnableReactiveMongoRepositories("learn.repository")
public class ReactiveMongoConfiguration {

    private static final String DATABASE_NAME = "learn-kafka-dev";

    public ReactiveMongoDatabaseFactory mongoDbFactory(MongoClient client) {
        return new SimpleReactiveMongoDatabaseFactory(client, DATABASE_NAME);
    }

    @Lazy
    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(MongoClient client) {
        return new ReactiveMongoTemplate(mongoDbFactory(client));
    }

}
