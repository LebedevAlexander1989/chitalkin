package org.chitalkin.ru.adapters.persistence.storage.impl;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;
import org.chitalkin.ru.adapters.persistence.storage.BookDao;

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
