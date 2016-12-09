package com.peoplematter.selenium.interfaces;

import org.openqa.selenium.WebElement;

/**
 * Created by sai.boju on 11/15/16.
 */
@FunctionalInterface
public interface FluentCondition {

    public boolean evaluate(WebElement webElement);
}
