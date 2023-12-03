package org.example.library.core.mapper;

import org.example.library.adapters.persistence.entity.BookEntity;
import org.example.library.core.domain.Book;

public class BookMapper {

    public Book toBook(BookEntity bookEntity) {
        return Book.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .build();
    }
}
