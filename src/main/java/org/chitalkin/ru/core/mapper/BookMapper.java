package org.chitalkin.ru.core.mapper;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;
import org.chitalkin.ru.core.domain.Book;

public class BookMapper {

    public Book toBook(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .build();
    }
}
