package webdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdemo.entities.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findByUsername(String username);

}
