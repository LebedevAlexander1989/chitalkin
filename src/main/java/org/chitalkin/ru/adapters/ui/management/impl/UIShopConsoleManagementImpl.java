package org.chitalkin.ru.adapters.ui.management.impl;

import org.chitalkin.ru.adapters.ui.dto.OutputBookDto;
import org.chitalkin.ru.adapters.ui.management.UIShopConsoleManagement;
import org.chitalkin.ru.adapters.ui.mapper.OutputBookDtoMapper;
import org.chitalkin.ru.core.service.BookService;

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
