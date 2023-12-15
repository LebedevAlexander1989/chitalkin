package org.example.library.core.service;


import org.example.library.api.dto.RequestBookDto;
import org.example.library.core.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book add(RequestBookDto request);

    void update(RequestBookDto request);

    String getStatus(int id);
}
