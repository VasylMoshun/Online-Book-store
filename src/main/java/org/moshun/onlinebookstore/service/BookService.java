package org.moshun.onlinebookstore.service;

import java.util.List;
import org.moshun.onlinebookstore.dto.BookSearchParametersDto;
import org.moshun.onlinebookstore.model.Book;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Book save(Book book);

    List<Book> findAll(Pageable pageable);

    Book findById(Long id);

    Book updateBook(Long id, Book book);

    void deleteBookById(Long id);

    List<Book> search(BookSearchParametersDto parametersDto, Pageable pageable);
}
