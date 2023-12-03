package org.example.library.adapters.ui.validator.impl;

import org.example.library.adapters.ui.input.UIShopConsoleMenuInput;
import org.example.library.adapters.ui.validator.UIShopConsoleMenuInputValidator;

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
