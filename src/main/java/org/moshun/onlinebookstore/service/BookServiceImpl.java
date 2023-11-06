package org.moshun.onlinebookstore.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.dto.BookDto;
import org.moshun.onlinebookstore.dto.CreateBookRequestDto;
import org.moshun.onlinebookstore.exception.EntityNotFoundException;
import org.moshun.onlinebookstore.mapper.BookMapper;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find book by id " + id)
        );
        return bookMapper.toDto(book);
    }
}
