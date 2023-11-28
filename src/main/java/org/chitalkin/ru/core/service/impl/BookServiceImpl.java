package org.chitalkin.ru.core.service.impl;

import org.chitalkin.ru.adapters.persistence.repository.BookRepository;
import org.chitalkin.ru.core.dto.BookDto;
import org.chitalkin.ru.core.mapper.BookDtoMapper;
import org.chitalkin.ru.core.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookDtoMapper bookDtoMapper;

    public BookServiceImpl(BookRepository bookRepository,
                           BookDtoMapper bookDtoMapper) {
        this.bookRepository = bookRepository;
        this.bookDtoMapper = bookDtoMapper;
    }

    @Override
    public List<BookDto> getAll() {
        return bookRepository.getAll()
                .stream()
                .map(bookDtoMapper::toBookDto)
                .toList();
    }
}
