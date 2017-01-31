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
    private static final String PDF_BUTTON = "//android.widget.TextView[@text='PDF new']";
    private static final String VIEW_DOCUMENT_BUTTON = "//android.widget.TextView[@text='View Document']";
    private static final String ERROR_MESSAGE = "//android.widget.TextView[@text='Oops! You do not have an application installed that can view this type of file: pdf.']";
    private static final String VIDEOSAI_BUTTON = "//android.widget.TextView[@text='VideoSai']";
    private static final String VIDEOSAI_TEXT = "//android.widget.TextView[@text='VideoSai']";
    private static final String DESCRIPTION_TEXT = "com.peoplematter.android:id/description";
    private static final String DUE_DATE_VIEW = "com.peoplematter.android:id/due_date";
    private static final String CHECKBOX = "com.peoplematter.android:id/ack_container";
    private static final String SAVE_BUTTON = "//android.widget.TextView[@text='Save']";
    private static final String MESSAGESAI_TEXT = "//android.widget.TextView[@text='MessageSai']";
    private static final String MESSAGE_DISPLAY = "com.peoplematter.android:id/message";

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

//141442//
    public boolean clickOnPdfButtonAndGetMessage() throws InterruptedException {
        getfd().element(By.xpath(PDF_BUTTON)).waitUntil(MAX_TIME).
                ifElementIsNotDisplayed().click();
       // Thread.sleep(3000);
       // getfd().executeScript("arguments[0].click();", getfd().element(By.xpath(VIEW_DOCUMENT_BUTTON)).getElement());
         // Application.getAndroidDriver().switchTo().frame(0);
        getfd().element(By.xpath(VIEW_DOCUMENT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return getfd().element(By.xpath(ERROR_MESSAGE)).waitUntil(MAX_TIME).
                ifElementIsNotDisplayed().isDisplayed();
    }

    public ActionItemsPage clickOnVideoSaiButton(){
        getfd().element(By.xpath(VIDEOSAI_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

public ActionItemsPage verifyDescription(){
    getfd().element(By.id(DESCRIPTION_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
    return this;
}

    public ActionItemsPage verifyDateIsDisplayed(){
        getfd().element(By.id(DUE_DATE_VIEW)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ActionItemsPage clickOnCheckBox(){
        getfd().element(By.id(CHECKBOX)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ActionItemsPage clickOnSaveButton(){
        getfd().element(By.xpath(SAVE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ActionItemsPage verifyVideoSaiText(){
        getfd().element(By.xpath(VIDEOSAI_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ActionItemsPage clickOnMessageSaiButton(){
        getfd().element(By.xpath(MESSAGESAI_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ActionItemsPage verifyMessageSaiText(){
        getfd().element(By.xpath(MESSAGESAI_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }



    public ActionItemsPage verifyDisplayedMesssage(){
        getfd().element(By.id(MESSAGE_DISPLAY)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

}
