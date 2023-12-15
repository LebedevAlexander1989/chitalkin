package org.example.library.core.service;

import org.example.core.domain.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book add(Book book);

    void update(Book book);

    String getStatus(int id);
}
