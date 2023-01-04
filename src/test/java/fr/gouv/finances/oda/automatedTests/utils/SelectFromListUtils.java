/*
 * Copyright (c) 2022 DGFiP - Tous droits réservés
 */
package fr.gouv.finances.oda.automatedTests.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * This class is used to select value from dropdown list.
 */
public class SelectFromListUtils
{

    /**
     * This method is used to select value from dropdown list by visible text. Here we need to have two parameters locator
     * type and string text.
     * @param element element to be selected
     * @param text    The exactly displayed text of a particular option
     */
    public void selectDropDownListByVisibleText(WebElement element, String text)
    {
        Select dropDownList = new Select(element);
        dropDownList.selectByVisibleText(text);
    }

    /**
     * This method is used to select value from dropdown list by index. Here we need to have two parameters locator type and
     * option index.
     * @param element element to be selected
     * @param index   the index of the option to be selected
     */
    public void selectDropDownListByIndex(WebElement element, int index)
    {
        Select dropDownList = new Select(element);
        dropDownList.selectByIndex(index);
    }

    /**
     * This method is used to select value from dropdown list by value. Here we need to have two parameters locator type and
     * string text.
     * @param element element to be selected
     * @param value   value of the “value” attribute
     */
    public void selectDropDownListByValue(WebElement element, String value)
    {
        Select dropDownList = new Select(element);
        dropDownList.selectByValue(value);
    }
}
