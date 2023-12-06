package org.moshun.onlinebookstore.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.moshun.onlinebookstore.dto.bookdto.BookSearchParametersDto;
import org.moshun.onlinebookstore.dto.userdto.UserRegistrationRequestDto;
import org.moshun.onlinebookstore.dto.userdto.UserResponseDto;
import org.moshun.onlinebookstore.exception.EntityNotFoundException;
import org.moshun.onlinebookstore.exception.RegistrationException;
import org.moshun.onlinebookstore.mapper.UserMapper;
import org.moshun.onlinebookstore.model.Book;
import org.moshun.onlinebookstore.model.User;
import org.moshun.onlinebookstore.repository.UserRepository;
import org.moshun.onlinebookstore.repository.book.BookRepository;
import org.moshun.onlinebookstore.repository.book.BookSpecificationBuilder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookSpecificationBuilder specificationBuilder;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable).stream().toList();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find book by id " + id)
        );
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book bookById = bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Could not find book by id " + id));
        bookById.setAuthor(book.getAuthor());
        bookById.setTitle(book.getTitle());
        bookById.setPrice(book.getPrice());
        bookById.setDescription(book.getDescription());
        bookById.setIsbn(book.getIsbn());
        bookById.setCoverImage(book.getCoverImage());
        return bookRepository.save(bookById);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> search(BookSearchParametersDto parameters, Pageable pageable) {
        Specification<Book> bookSpecification = specificationBuilder.build(parameters);
        return bookRepository.findAll(bookSpecification,pageable).stream().toList();
    }

    @Override
    public UserResponseDto registration(UserRegistrationRequestDto requestDto)
            throws RegistrationException {
        if (userRepository.findByEmail(requestDto.getEmail()).isPresent()) {
            throw new RegistrationException("User with email: "
                    + requestDto.getEmail() + " already exist");
        }
        User user = new User();
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        user.setShippingAddress(requestDto.getShippingAddress());
        return userMapper.toDto(userRepository.save(user));
    }
}
