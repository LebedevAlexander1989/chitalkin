package org.chitalkin.ru.adapters.ui.mapper;

import org.chitalkin.ru.adapters.ui.dto.OutputBookDto;
import org.chitalkin.ru.core.domain.Book;

public class OutputBookDtoMapper {

    public OutputBookDto toOutputDto(Book book) {
        return OutputBookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }
}
