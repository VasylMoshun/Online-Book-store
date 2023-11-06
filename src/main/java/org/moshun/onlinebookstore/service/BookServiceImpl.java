package org.moshun.onlinebookstore.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.exception.EntityNotFoundException;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find book by id " + id)
        );
        return book;
    }

    //    @Override
    //    public Book updateBook(Long id, Book book) {
    //        Book bookById = bookRepository.findById(id).orElseThrow(
    //                () -> new EntityNotFoundException("Could not find book by id " + id));
    //        return bookRepository.updateById(id, book);
    //    }
}
