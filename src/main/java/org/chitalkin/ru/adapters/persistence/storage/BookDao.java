package org.chitalkin.ru.adapters.persistence.storage;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;

import java.util.List;

public interface BookDao {

    List<BookEntity> getAll();
}
