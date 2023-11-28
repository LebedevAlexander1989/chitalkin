package org.chitalkin.ru.core.mapper;

import org.chitalkin.ru.adapters.persistence.entity.BookEntity;
import org.chitalkin.ru.core.dto.BookDto;

public class BookDtoMapper {

    public BookDto toBookDto(BookEntity bookEntity) {
        return BookDto.builder()
                .id(bookEntity.getId())
                .name(bookEntity.getName())
                .build();
    }
}
