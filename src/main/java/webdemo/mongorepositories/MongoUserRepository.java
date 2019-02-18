package webdemo.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webdemo.mongoentities.MyMongoUser;

@Repository
public interface MongoUserRepository extends MongoRepository<MyMongoUser, String> {

    MyMongoUser findByUsername(String username);
}
