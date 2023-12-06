package org.example.core.service.impl;

import org.example.core.domain.Book;
import org.example.core.service.BookService;
import org.example.persistence.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(b -> new Book(b.getId(), b.getName()))
                .toList();
    }
}
