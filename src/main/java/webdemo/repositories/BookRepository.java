package webdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import webdemo.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
