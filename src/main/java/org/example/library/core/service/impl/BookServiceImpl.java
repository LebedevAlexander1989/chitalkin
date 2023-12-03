package org.example.library.core.service.impl;

import org.example.library.adapters.persistence.repository.BookRepository;
import org.example.library.core.domain.Book;
import org.example.library.core.mapper.BookMapper;
import org.example.library.core.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll()
                .stream()
                .map(bookMapper::toBook)
                .toList();
    }
}
