package org.chitalkin.ru.adapters.ui.mapper;

import org.chitalkin.ru.adapters.ui.dto.OutputBookDto;
import org.chitalkin.ru.core.dto.BookDto;

public class OutputBookDtoMapper {

    public OutputBookDto toOutputDto(BookDto bookDto) {
        return OutputBookDto.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .build();
    }
}
