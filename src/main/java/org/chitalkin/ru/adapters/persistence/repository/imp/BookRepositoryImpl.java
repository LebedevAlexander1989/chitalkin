package org.chitalkin.ru.adapters.persistence.repository.imp;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;
import org.chitalkin.ru.adapters.persistence.repository.BookRepository;
import org.chitalkin.ru.adapters.persistence.storage.BookDao;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private final BookDao bookDao;

    public BookRepositoryImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<BookEntity> getAll() {
        return bookDao.getAll();
    }
}
