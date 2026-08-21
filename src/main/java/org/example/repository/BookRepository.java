package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    // Spring Boot automatically creates the query: SELECT * FROM book WHERE title = ?
    List<Book> findByTitle(String title);
}