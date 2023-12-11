package org.example.persistence.service;

import org.example.persistence.entity.BookEntity;

import java.util.List;

public interface BookEntityService {

    List<BookEntity> getAll();

    BookEntity add(BookEntity entity);

    String getStatus(int id);

    BookEntity findById(int id);
}
