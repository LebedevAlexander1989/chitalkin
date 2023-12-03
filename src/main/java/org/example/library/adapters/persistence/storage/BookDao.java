package org.example.library.adapters.persistence.storage;

import org.example.library.adapters.persistence.entity.BookEntity;

import java.util.List;

public interface BookDao {

    List<BookEntity> getAll();
}
