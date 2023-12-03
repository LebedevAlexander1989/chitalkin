package org.example.library.adapters.ui.input.impl;

import org.example.library.adapters.ui.input.UIShopConsoleMenuInput;

import java.util.Scanner;

public class UIShopConsoleMenuInputImpl implements UIShopConsoleMenuInput {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String input() {
        return scanner.nextLine();
    }
}
