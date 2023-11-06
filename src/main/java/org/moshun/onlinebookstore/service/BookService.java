package org.moshun.onlinebookstore.service;

import java.util.List;
import org.moshun.onlinebookstore.model.Book;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    Book findById(Long id);

    //public Book updateBook(Long id, Book book);
}
