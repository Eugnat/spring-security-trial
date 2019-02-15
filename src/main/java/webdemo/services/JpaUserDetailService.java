package webdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import webdemo.entities.MyUser;
import webdemo.entities.Role;
import webdemo.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class JpaUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        MyUser myUser = repository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        if (myUser.getRoles() == null) {
            throw new UsernameNotFoundException("User doesn't have any roles");
        }

        for (Role role : myUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(myUser.getUsername(), myUser.getPassword(), grantedAuthorities);

    }
}
