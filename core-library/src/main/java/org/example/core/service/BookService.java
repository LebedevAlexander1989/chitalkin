package org.example.core.service;

import org.example.core.dto.BookDto;

import java.util.List;

public interface BookService {

    List<BookDto> getAll();

    BookDto add(BookDto bookDto);

    void update(BookDto bookDto);

    String getStatus(int id);
}
