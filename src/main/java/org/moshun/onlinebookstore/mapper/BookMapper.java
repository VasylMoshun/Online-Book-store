package org.moshun.onlinebookstore.mapper;

import org.mapstruct.Mapper;
import org.moshun.onlinebookstore.config.MapperConfig;
import org.moshun.onlinebookstore.dto.BookDto;
import org.moshun.onlinebookstore.dto.CreateBookRequestDto;
import org.moshun.onlinebookstore.model.Book;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);
}
