package org.moshun.onlinebookstore.repository.book.spec;

import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.repository.SpecificationProvider;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class TitleSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "title";
    }

    public Specification<Book> getSpecification(String title) {
        return (root, query, criteriaBuilder) -> criteriaBuilder
                .like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }
}
