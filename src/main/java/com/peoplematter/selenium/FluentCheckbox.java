package com.peoplematter.selenium;

import com.peoplematter.selenium.interfaces.Condition;
import com.peoplematter.selenium.interfaces.FluentCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FluentCheckbox {

    MobileFluentWait<FluentCheckbox> fluentCheckboxFluentWait;
    By by;
    WebDriver driver;
    private SearchContext searchContext;
    private WebDriver webDriver;
    private FluentElement fluentElement;

    public FluentCheckbox(By by, WebDriver webDriver, SearchContext searchContext) {
        this.by = by;
        this.searchContext = searchContext;
        this.webDriver = webDriver;
    }

    public FluentCheckbox(By by, WebDriver webDriver) {
        this.by = by;
        this.searchContext = webDriver;
        this.webDriver = webDriver;
    }

    public MobileFluentWait<FluentCheckbox> waitUntil(int timeOut) {
        this.fluentCheckboxFluentWait = new MobileFluentWait<FluentCheckbox>(timeOut, this, by, driver);
        return fluentCheckboxFluentWait;
    }

    public FluentCheckbox check(final Condition condition) {
        if (condition.evaluate()) {
            fluentElement.getElement().click();
        }
        return this;
    }

    public FluentCheckbox unCheck(final Condition condition) {
        if (!condition.evaluate()) {
            fluentElement.getElement().click();
        }
        return this;
    }

    public FluentCheckbox check(final FluentCondition condition) {
        WebElement webElement = fluentElement.getElement();
        if (condition.evaluate(webElement)) {
            webElement.click();
        }
        return this;
    }


    /**
     * @param condition
     * @return
     */
    public FluentCheckbox unCheck(final FluentCondition condition) {
        WebElement webElement = fluentElement.getElement();
        if (!condition.evaluate(webElement)) {
            webElement.click();
        }
        return this;
    }

    public boolean isSelected() {
        return fluentElement.getElement().isSelected();
    }

}
