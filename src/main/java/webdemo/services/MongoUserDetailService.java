package webdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import webdemo.mongoentities.MongoRole;
import webdemo.mongoentities.MyMongoUser;
import webdemo.mongorepositories.MongoRoleRepository;
import webdemo.mongorepositories.MongoUserRepository;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class MongoUserDetailService implements UserDetailsService {

    @Autowired
    private MongoUserRepository userRepository;

    @Autowired
    private MongoRoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyMongoUser myUser = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if (myUser.getRoles() == null) {
            throw new UsernameNotFoundException("User doesn't have any roles");
        }

        for (MongoRole role : myUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(myUser.getUsername(), myUser.getPassword(), grantedAuthorities);

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
