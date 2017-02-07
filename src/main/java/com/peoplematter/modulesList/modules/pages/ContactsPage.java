package com.peoplematter.modulesList.modules.pages;


import com.peoplematter.pageObjects.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

/**
 * Created by sai.boju on 1/18/17.
 */

public class ContactsPage extends BasePage {
    AndroidDriver driver;


    private static final String LOCATION = "com.peoplematter.android:id/action_bar_custom_view_subtitle";
    private static final String LOCATION_NAME = "//android.widget.TextView[@text='Alpharetta Location 3']";
    private static final String SEARCH_BUTTON = "com.peoplematter.android:id/search_edit_text";
    private static final String MARY_BALDWIN = "//android.widget.TextView[@text='Mary Baldwin']";
    private static final String BACKBUTTON = "//android.widget.ImageButton";
    private static final String DOCUMENT_PHOTO_UPLOAD ="//android.widget.TextView[@text='Document photo upload']";
    private static final String VIEW_DOCUMENT_DETAILS = "//android.widget.TextView[@text='View document details']";
    private static final String VERIFY_FILE = "//android.widget.TextView[@text='%s']";


    public ContactsPage clickOnLocation() {
        getfd().element(By.id(LOCATION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ContactsPage clickOnLocationName()  {
        getfd().element(By.xpath(LOCATION_NAME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public ContactsPage clickOnSearchButton()  {
        getfd().element(By.id(SEARCH_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ContactsPage enterContactName()  {
        getfd().element(By.id(SEARCH_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("Mary Baldwin");

        return this;
    }

    public ContactsPage clickOnMaryBaldwin()  {
        getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getfd().element(By.xpath(BACKBUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public ContactsPage clickOnBackButton()  {
        getfd().element(By.xpath(BACKBUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return this;
    }

    public ContactsPage clickOnViewDocumentDetails() {
       // getfd().element(By.xpath(String.format(DOCUMENT_PHOTO_UPLOAD,"Document photo upload"))).getElements().forEach
            //    (WebElement::click);
        getfd().element(By.xpath(DOCUMENT_PHOTO_UPLOAD)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getfd().element(By.xpath(VIEW_DOCUMENT_DETAILS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ContactsPage verifyUploadedFile() {

        getfd().element(By.xpath(String.format(VERIFY_FILE, "MaryBaldwinOther.jpeg"))).isDisplayed();
        return this;
    }

    public ContactsPage maryBaldwinIsDisplayed() {

        getfd().element(By.xpath(MARY_BALDWIN)).isDisplayed();
        return this;

    }


}
