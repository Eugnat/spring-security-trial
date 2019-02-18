package webdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import webdemo.mongoentities.MongoRole;
import webdemo.mongoentities.MyMongoUser;

import java.util.HashSet;
import java.util.Set;

@Component
public class MongoUserDetailService implements UserDetailsService {

    @Autowired
    private MyUserService repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyMongoUser myUser = repository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if (myUser.getRoles() == null) {
            throw new UsernameNotFoundException("User doesn't have any roles");
        }

        for (MongoRole role : myUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(myUser.getUsername(), myUser.getPassword(), grantedAuthorities);

    }
}
