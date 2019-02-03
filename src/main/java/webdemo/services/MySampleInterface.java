package webdemo.services;

import org.springframework.security.access.prepost.PreAuthorize;

public interface MySampleInterface {

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    void printUsername(String userName);
}
