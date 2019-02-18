package webdemo.mongorepositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import webdemo.mongoentities.MongoRole;

@Repository
public interface MongoRoleRepository extends MongoRepository<MongoRole, String> {

    MongoRole findByName(String name);
}
