package webdemo.services;

import org.springframework.stereotype.Service;
import webdemo.entities.MyUser;

@Service
public interface MyUserService {

    MyUser findByUsername(String username);
}
