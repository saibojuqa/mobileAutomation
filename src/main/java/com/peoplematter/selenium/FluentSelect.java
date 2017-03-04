package com.peoplematter.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by sai.boju on 11/15/16.
 */
public class FluentSelect {

    final FluentElement fluentElement;
    final private WebDriver driver;
    final private By by;


    public FluentSelect(final By by, final WebDriver webDriver, SearchContext searchContext) {
        this.by = by;
        this.fluentElement = new FluentElement(by, webDriver, searchContext);
        this.driver = webDriver;
    }

    public FluentSelect(final By by, final WebDriver webDriver) {
        this.by = by;
        this.fluentElement = new FluentElement(by, webDriver, webDriver);
        this.driver = webDriver;
    }


    public void selectByText(final String text) {
        Select select = new Select(fluentElement.getElement());
        select.selectByVisibleText(text);
    }


}
