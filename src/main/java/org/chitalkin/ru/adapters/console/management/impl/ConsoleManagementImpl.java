package org.chitalkin.ru.adapters.console.management.impl;

import org.chitalkin.ru.adapters.console.dto.ResponseBookDto;
import org.chitalkin.ru.adapters.console.management.ConsoleManagement;
import org.chitalkin.ru.adapters.console.service.ConsoleService;

import java.util.List;

public class ConsoleManagementImpl implements ConsoleManagement {
    private final ConsoleService consoleService;

    public ConsoleManagementImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public List<ResponseBookDto> getAll() {
        return consoleService.showAll();
    }
}
