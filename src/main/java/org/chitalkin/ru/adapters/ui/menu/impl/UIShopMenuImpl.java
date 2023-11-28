package org.chitalkin.ru.adapters.ui.menu.impl;

import org.chitalkin.ru.adapters.ui.dto.OutputBookDto;
import org.chitalkin.ru.adapters.ui.management.UIShopManagement;
import org.chitalkin.ru.adapters.ui.menu.UIShopMenu;
import org.chitalkin.ru.adapters.ui.validator.UIShopMenuInputValidator;

import java.util.List;

public class UIShopMenuImpl implements UIShopMenu {

    private final UIShopManagement management;

    private final UIShopMenuInputValidator validator;

    public UIShopMenuImpl(UIShopManagement management,
                          UIShopMenuInputValidator validator) {
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
