package org.moshun.onlinebookstore.controller;

import java.util.List;
import org.moshun.onlinebookstore.dto.BookDto;
import org.moshun.onlinebookstore.dto.BookSearchParametersDto;
import org.moshun.onlinebookstore.dto.CreateBookRequestDto;
import org.moshun.onlinebookstore.mapper.BookMapper;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return bookMapper.toDto(book);
    }

    @GetMapping("/search")
    public List<BookDto> searchBooks(BookSearchParametersDto searchParameters) {
        return bookService.search(searchParameters).stream()
                .map(bookMapper::toDto).toList();
    }

    @PostMapping
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        Book book = bookService.save(bookMapper.toModel(bookDto));
        return bookMapper.toDto(book);
    }

    @PutMapping("/{id}")
    public BookDto updatedBook(@PathVariable Long id,
                               @RequestBody CreateBookRequestDto requestDto) {
        return bookMapper.toDto(bookService.updateBook(id, bookMapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
