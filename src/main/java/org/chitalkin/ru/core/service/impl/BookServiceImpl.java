package org.chitalkin.ru.core.service.impl;

import org.chitalkin.ru.adapters.persistence.repository.BookRepository;
import org.chitalkin.ru.core.domain.Book;
import org.chitalkin.ru.core.mapper.BookMapper;
import org.chitalkin.ru.core.service.BookService;

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
