package org.chitalkin.ru.adapters.persistence.repository;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;

import java.util.List;

public interface BookRepository {

    List<BookEntity> getAll();
}
