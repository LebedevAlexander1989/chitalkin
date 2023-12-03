package org.example.library.adapters.ui.menu.impl;

import org.example.library.adapters.ui.dto.OutputBookDto;
import org.example.library.adapters.ui.management.UIShopConsoleManagement;
import org.example.library.adapters.ui.menu.UIShopConsoleMenu;
import org.example.library.adapters.ui.validator.UIShopConsoleMenuInputValidator;

import java.util.List;

public class UIShopConsoleMenuImpl implements UIShopConsoleMenu {

    private final UIShopConsoleManagement management;

    private final UIShopConsoleMenuInputValidator validator;

    public UIShopConsoleMenuImpl(UIShopConsoleManagement management,
                                 UIShopConsoleMenuInputValidator validator) {
        this.management = management;
        this.validator = validator;
    }

    @Override
    public void show() {
        System.out.println("Добро пожаловать в интернет - магазин 'Читалкин'");
        System.out.println();

        boolean isFinish = false;
        while (!isFinish) {
            System.out.println("Меню:");
            System.out.println("1. Показать доступные книги");
            System.out.println("2. Выйти");

            String input = String.valueOf(validator.validInput());
            if ("1".equals(input)) {
                List<OutputBookDto> outputBooks = management.showAll();
                outputBooks.forEach(System.out::println);
                System.out.println();
            }

            if ("2".equals(input)) {
                isFinish = true;
            }
        }
    }
}
