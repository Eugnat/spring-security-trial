package webdemo.services;

import org.springframework.stereotype.Service;
import webdemo.mongoentities.MyMongoUser;

@Service
public interface MyUserService {

    MyMongoUser findByUsername(String username);
}
