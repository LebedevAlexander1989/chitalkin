package org.chitalkin.ru.adapters.persistence.repository.imp;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;
import org.chitalkin.ru.adapters.persistence.repository.BookRepository;
import org.chitalkin.ru.adapters.persistence.storage.BookStorage;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private final BookStorage bookStorage;

    public BookRepositoryImpl(BookStorage bookStorage) {
        this.bookStorage = bookStorage;
    }

    @Override
    public List<BookEntity> getAll() {
        return bookStorage.getAll();
    }
}
