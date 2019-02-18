package webdemo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import webdemo.mongoentities.MongoRole;
import webdemo.mongoentities.MyMongoUser;
import webdemo.mongorepositories.MongoRoleRepository;
import webdemo.mongorepositories.MongoUserRepository;
import webdemo.services.MyUserService;

import javax.annotation.PostConstruct;

public class MyUserServiceImpl implements MyUserService {

    @Autowired
    private MongoUserRepository userRepository;

    @Autowired
    private MongoRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public MyMongoUser findByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @PostConstruct
    public void initializeDatabase() {
        MyMongoUser user1 = new MyMongoUser();
        user1.setUsername("user1");
        user1.setPassword(encoder.encode("user1"));

        MongoRole role = new MongoRole();
        role.setName("ROLE_ADMIN");

        if (roleRepository.findByName("ROLE_ADMIN") == null) {
            roleRepository.save(role);
        }

        user1.addRole(role);

        if (userRepository.findByUsername("user1") == null) {
            userRepository.save(user1);
        }
    }
}
