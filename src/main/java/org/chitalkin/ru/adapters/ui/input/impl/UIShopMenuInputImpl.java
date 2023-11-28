package org.chitalkin.ru.adapters.ui.input.impl;

import org.chitalkin.ru.adapters.ui.input.UIShopMenuInput;

import java.util.Scanner;

public class UIShopMenuInputImpl implements UIShopMenuInput {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        return scanner.nextLine();
    }
}
