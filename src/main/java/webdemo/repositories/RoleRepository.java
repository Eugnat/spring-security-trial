package webdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdemo.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
