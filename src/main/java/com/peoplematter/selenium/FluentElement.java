package com.peoplematter.selenium;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;

import java.util.List;

@Log4j
public class FluentElement {

    private By by;
    private String elementName;
    private SearchContext searchContext;
    private WebDriver webDriver;
    MobileFluentWait<FluentElement> fluentWait;

    public FluentElement(By by, WebDriver webDriver, SearchContext searchContext) {
        this.by = by;
        this.searchContext = searchContext;
        this.webDriver = webDriver;
    }

    public FluentElement(By by, WebDriver webDriver) {
        this.by = by;
        this.searchContext = webDriver;
        this.webDriver = webDriver;
    }

    public MobileFluentWait<FluentElement> waitUntil(int timeOut) {
        MobileFluentWait<FluentElement> fluentWait = new MobileFluentWait<FluentElement>(timeOut, this, by, searchContext);
        this.fluentWait = fluentWait;
        return fluentWait;
    }


    public MobileFluentWait<FluentElement> getFluentWait() {
        return fluentWait;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    By getBy() {
        return by;
    }

    public WebElement getElement() {
        return WebElementProvider.get(searchContext).getElement(this);
    }

    public List<WebElement> getElements(){
        return searchContext.findElements(by);
    }

    public void click() {
        log.debug(String.format("clicking on element %s", by));
        getElement().click();
    }


    public FluentElement sendKeys(String value) {
        log.debug(String.format("Typing value %s in %s", value, by));
        getElement().sendKeys(value);
        return this;
    }

    public FluentElement clear() {
        log.debug(String.format("clearing %s field", by));
        getElement().clear();
        return this;
    }

    public String getText() {
        return getElement().getText();
    }

    public boolean isDisplayed() {
        try {
            return getElement().isDisplayed();
        } catch (WebDriverException ex) {
            return false;
        }
    }

    public FluentElement bringElementInView() {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", getElement());
        return this;
    }

    public FluentElement jsClick() {
        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].click();", getElement());
        return this;
    }


    }
