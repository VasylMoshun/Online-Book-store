package org.moshun.onlinebookstore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.moshun.onlinebookstore.dto.bookDto.BookDto;
import org.moshun.onlinebookstore.dto.bookDto.BookSearchParametersDto;
import org.moshun.onlinebookstore.dto.bookDto.CreateBookRequestDto;
import org.moshun.onlinebookstore.mapper.BookMapper;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.service.BookService;
import org.springframework.data.domain.Pageable;
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
@Tag(name = "Book management", description = "Endpoints to managing books ")
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping
    @Operation(summary = "Get all books", description = "Get a list of all books")
    public List<BookDto> getAll(Pageable pageable) {
        return bookService.findAll(pageable).stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get book by id", description = "Get a book by book id")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookService.findById(id);
        return bookMapper.toDto(book);
    }

    @GetMapping("/search")
    @Operation(summary = "Search book parameters",
            description = "Search book by title, isbn, author")
    public List<BookDto> searchBooks(BookSearchParametersDto searchParameters, Pageable pageable) {
        return bookService.search(searchParameters, pageable).stream()
                .map(bookMapper::toDto).toList();
    }

    @PostMapping
    @Operation(summary = "Create a new book", description = "Create a new book")
    public BookDto createBook(@RequestBody CreateBookRequestDto bookDto) {
        Book book = bookService.save(bookMapper.toModel(bookDto));
        return bookMapper.toDto(book);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a  book by id", description = "Update a  book by id")
    public BookDto updatedBook(@PathVariable Long id,
                               @RequestBody CreateBookRequestDto requestDto) {
        return bookMapper.toDto(bookService.updateBook(id, bookMapper.toModel(requestDto)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete  a  book by id", description = "Delete a  book by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
    }
}
