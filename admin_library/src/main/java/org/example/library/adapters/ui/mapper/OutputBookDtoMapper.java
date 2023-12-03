package org.example.library.adapters.ui.mapper;

import org.example.library.adapters.ui.dto.OutputBookDto;
import org.example.library.core.domain.Book;

public class OutputBookDtoMapper {

    public OutputBookDto toOutputDto(Book book) {
        return OutputBookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }
}
