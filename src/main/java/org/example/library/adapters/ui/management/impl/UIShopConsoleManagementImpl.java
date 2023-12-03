package org.example.library.adapters.ui.management.impl;

import org.example.library.adapters.ui.dto.OutputBookDto;
import org.example.library.adapters.ui.management.UIShopConsoleManagement;
import org.example.library.adapters.ui.mapper.OutputBookDtoMapper;
import org.example.library.core.service.BookService;

import java.util.List;

public class UIShopConsoleManagementImpl implements UIShopConsoleManagement {
    private final BookService bookService;

    private final OutputBookDtoMapper outputBookDtoMapper;

    public UIShopConsoleManagementImpl(BookService bookService,
                                       OutputBookDtoMapper outputBookDtoMapper) {
        this.bookService = bookService;
        this.outputBookDtoMapper = outputBookDtoMapper;
    }

    @Override
    public List<OutputBookDto> showAll() {
        return bookService.getAll()
                .stream()
                .map(outputBookDtoMapper::toOutputDto)
                .toList();
    }
}
