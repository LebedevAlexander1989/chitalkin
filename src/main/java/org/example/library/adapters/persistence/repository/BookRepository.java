package org.example.library.adapters.persistence.repository;

import org.example.library.adapters.persistence.entity.BookEntity;

import java.util.List;

public interface BookRepository {

    List<BookEntity> getAll();
}
