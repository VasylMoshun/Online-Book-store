package org.moshun.onlinebookstore.repository.book;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.repository.SpecificationProvider;
import org.moshun.onlinebookstore.repository.SpecificationProviderManager;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProvider;

    @Override
    public SpecificationProvider<Book> getSpecification(String key) {
        return bookSpecificationProvider.stream()
                .filter(
                        p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Could not find correct provider or key" + key));
    }
}
