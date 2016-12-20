package com.peoplematter.selenium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FluentDriver {
    private WebDriver webDriver;


    public FluentDriver(AndroidDriver androidDriver){
        this.webDriver=androidDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public FluentElement element(By by) {
        return new FluentElement(by, webDriver, webDriver);
    }
    public Object executeScript(final String script, final Object... args) {
        return ((JavascriptExecutor) webDriver).executeScript(script, args);
    }
    public FluentButton button(By by) {
        return new FluentButton(by, webDriver, webDriver);
    }


    public FluentInput input(By by) {
        return new FluentInput(by, webDriver, webDriver);
    }

    public FluentLink link(By by) {
        return new FluentLink(by, webDriver, webDriver);
    }

    public FluentRadio radio(By by) {
        return new FluentRadio(by, webDriver, webDriver);
    }

    public void navigateBack() {
        webDriver.navigate().back();
    }

}
