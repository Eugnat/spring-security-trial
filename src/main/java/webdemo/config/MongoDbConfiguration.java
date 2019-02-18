package webdemo.config;

import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import webdemo.services.MyUserService;
import webdemo.services.impl.MyUserServiceImpl;

@Configuration
@EnableMongoRepositories(basePackages = {"webdemo.mongorepositories"})
public class MongoDbConfiguration {

    @Bean
    public MongoClient mongo() {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongo(), "test");
    }

    @Bean
    public MyUserService myUserService() {
        MyUserService myUserService = new MyUserServiceImpl();

        return myUserService;
    }


}
