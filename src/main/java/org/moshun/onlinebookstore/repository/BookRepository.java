package org.moshun.onlinebookstore.repository;

import java.util.List;
import org.moshun.onlinebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book save(Book book);

    List<Book> findAll();
}
