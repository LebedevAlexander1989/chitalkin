package org.chitalkin.ru.adapters.console;

import java.util.Scanner;

public class ConsoleController implements Console {

    private final Scanner in = new Scanner(System.in);

    @Override
    public void input() {
        String s = in.nextLine();
    }
}
