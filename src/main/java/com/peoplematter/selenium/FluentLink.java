package com.peoplematter.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

/**
 * Created by sai.boju on 11/14/16.
 */
public class FluentLink extends FluentElement {

    public FluentLink(By by, WebDriver webDriver, SearchContext searchContext) {
        super(by, webDriver, searchContext);
    }

    public FluentLink(By by, WebDriver webDriver) {
        super(by, webDriver);
    }
}
