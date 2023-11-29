package org.chitalkin.ru.adapters.ui.validator.impl;

import org.chitalkin.ru.adapters.ui.input.UIShopConsoleMenuInput;
import org.chitalkin.ru.adapters.ui.validator.UIShopConsoleMenuInputValidator;

public class UIShopConsoleMenuInputValidatorImpl implements UIShopConsoleMenuInputValidator {

    private final UIShopConsoleMenuInput uiShopConsoleMenuInput;

    public UIShopConsoleMenuInputValidatorImpl(UIShopConsoleMenuInput uiShopConsoleMenuInput) {
        this.uiShopConsoleMenuInput = uiShopConsoleMenuInput;
    }


    @Override
    public int validInput() {
        int result = 0;
        boolean isValid = false;
        while(!isValid) {
            try {
                result = Integer.parseInt(uiShopConsoleMenuInput.input());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Совершен некоректный ввод. Повторите, пожалуйста, снова");
            }
        }
        return result;
    }
}
