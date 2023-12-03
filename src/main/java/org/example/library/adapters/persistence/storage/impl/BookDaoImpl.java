package org.example.library.adapters.persistence.storage.impl;

import org.example.library.adapters.persistence.entity.BookEntity;
import org.example.library.adapters.persistence.storage.BookDao;

import java.util.List;

public class BookDaoImpl implements BookDao {

    private final List<BookEntity> books =
            List.of(
                    BookEntity.builder()
                            .id(1)
                            .name("Алиса в стране чудес")
                            .build());

    @Override
    public List<BookEntity> getAll() {
        return books;
    }
}
