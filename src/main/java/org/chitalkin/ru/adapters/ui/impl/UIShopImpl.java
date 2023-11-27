package org.chitalkin.ru.adapters.ui.impl;

import org.chitalkin.ru.adapters.console.management.impl.ConsoleManagementImpl;
import org.chitalkin.ru.adapters.ui.UIShop;

import java.util.Scanner;

public class UIShopImpl implements UIShop {

    private final Scanner in = new Scanner(System.in);

    private ConsoleManagementImpl controller;

    public UIShopImpl(ConsoleManagementImpl controller) {
        this.controller = controller;
    }

    @Override
    public void show() {
        System.out.println("Добро пожаловать в интернет - магазин 'Читалкин'");
        System.out.println();
        System.out.println("Меню");

        boolean isFinish = false;
        while (!isFinish) {
//            String input = in.nextLine();
//            if ("1".equals(input)) {
//                String all = controller.getAll();
//            }
//
//            if ("2".equals(input)) {
//
//            }
        }

    }
}
