package org.moshun.onlinebookstore.repository;

import org.moshun.onlinebookstore.dto.bookDto.BookSearchParametersDto;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build(BookSearchParametersDto bookSearchParametersDto);
}
