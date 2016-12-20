package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/13/16.
 */
public class ActionItemsPage extends BasePage {

    private static final String VIDEO_BUTTON = "//android.widget.TextView[@text='%s']";
    private static final String COMPLETED_BUTTON = "//android.widget.TextView[@text='Completed']";
    private static final String PDF_BUTTON = "//android.widget.TextView[@text='Test PDF not blocking by Job']";
    private static final String VIEW_DOCUMENT_BUTTON = "//android.widget.TextView[@text='View Document']";
    private static final String ERROR_MESSAGE = "//android.widget.TextView[@text='Oops! You do not have an " +
            "application installed that can view this type of file: pdf.']";


    public ActionItemsPage() {

    }


    public boolean isDescriptionVisible(String description) {
        return getfd().element(By.xpath(String.format(VIDEO_BUTTON, description))).waitUntil(MAX_TIME).
                ifElementIsNotDisplayed().isDisplayed();

    }


    public ActionItemsPage clickOnCompletedTab() {
        getfd().element(By.xpath(COMPLETED_BUTTON)).waitUntil(MAX_TIME).
                ifElementIsNotDisplayed().click();
        return this;

    }


    public boolean clickOnPdfButtonAndGetMessage() throws InterruptedException {
        getfd().element(By.xpath(PDF_BUTTON)).waitUntil(MAX_TIME).
                ifElementIsNotDisplayed().click();
        Thread.sleep(3000);
        getfd().executeScript("arguments[0].click();", getfd().element(By.xpath(VIEW_DOCUMENT_BUTTON)).getElement());
        Application.getAndroidDriver().switchTo().frame(0);
        getfd().element(By.xpath(VIEW_DOCUMENT_BUTTON)).waitUntil(3).ifElementIsNotDisplayed().click();
        return getfd().element(By.xpath(ERROR_MESSAGE)).waitUntil(MAX_TIME).
                ifElementIsNotDisplayed().isDisplayed();
    }

}
