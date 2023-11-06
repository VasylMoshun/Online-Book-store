package org.moshun.onlinebookstore.service;

import java.util.List;
import org.moshun.onlinebookstore.dto.BookDto;
import org.moshun.onlinebookstore.dto.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List findAll();

    BookDto findById(Long id);
}
