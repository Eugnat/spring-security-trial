package webdemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import webdemo.entities.MyUser;
import webdemo.repositories.UserRepository;
import webdemo.services.MyUserService;

public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public MyUser findByUsername(String username) {

        return userRepository.findByUsername(username);
    }
}
