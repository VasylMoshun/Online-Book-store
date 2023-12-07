package org.moshun.onlinebookstore.repository.book;

import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.dto.bookdto.BookSearchParametersDto;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.repository.SpecificationBuilder;
import org.moshun.onlinebookstore.repository.SpecificationProviderManager;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParametersDto bookSearchParametersDto) {
        Specification<Book> spec = Specification.where(null);
        if (bookSearchParametersDto.title() != null
                && bookSearchParametersDto.title().length() > 0) {
            spec = spec.and(specificationProviderManager.getSpecification("title")
                    .getSpecification(bookSearchParametersDto.title()));
        }
        if (bookSearchParametersDto.author() != null
                && bookSearchParametersDto.author().length() > 0) {
            spec = spec.and(specificationProviderManager.getSpecification("author")
                    .getSpecification(bookSearchParametersDto.author()));
        }
        if (bookSearchParametersDto.isbn() != null
                && bookSearchParametersDto.isbn().length() > 0) {
            spec = spec.and(specificationProviderManager.getSpecification("isbn")
                    .getSpecification(bookSearchParametersDto.isbn()));
        }
        return spec;
    }
}
