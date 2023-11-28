package org.chitalkin.ru.adapters.ui.validator.impl;

import org.chitalkin.ru.adapters.ui.input.UIShopMenuInput;
import org.chitalkin.ru.adapters.ui.validator.UIShopMenuInputValidator;

public class UIShopMenuInputValidatorImpl implements UIShopMenuInputValidator {

    private final UIShopMenuInput uiShopMenuInput;

    public UIShopMenuInputValidatorImpl(UIShopMenuInput uiShopMenuInput) {
        this.uiShopMenuInput = uiShopMenuInput;
    }


    @Override
    public int validInput() {
        int result = 0;
        boolean isValid = false;
        while(!isValid) {
            try {
                result = Integer.parseInt(uiShopMenuInput.input());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Совершен некоректный ввод. Повторите, пожалуйста, снова");
            }
        }
        return result;
    }
}
