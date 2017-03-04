package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by sai.boju on 12/20/16.
 */
public class HirePage extends BasePage {

    private static final String APPLICANT_BUTTON = "//android.widget.TextView[@text='%s']";
    private static final String VIEW_JOB_APPLICATION_LINK = "//android.widget.TextView[@text='View job application']";

    private static final String I9FORMBUTTON = "//android.widget.TextView[@text='%s']";
    private static final String I9FORMTEXT = "//android.widget.Textview[@text='Form I-9']";
    private static final String APPLICATION = "com.peoplematter.android:id/item_container";
    private static final String DOWNLOAD_FULL_JOB = "//android.widget.TextView[@text='Download full job application']";


    public HirePage clickOnDownloadFullJobApplication() {
        getfd().element(By.xpath(DOWNLOAD_FULL_JOB)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public HirePage clickOnNEwApplication() {
        getfd().element(By.id(APPLICATION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public HirePage clickOnApplicatButton() {
        getfd().
                element(By.xpath(String.format(APPLICANT_BUTTON, "Applicants"))).getElements().forEach
                (WebElement::click);
        return this;
    }

    public HirePage clickOnViewJobApplicationLink() {
        getfd().element(By.xpath(VIEW_JOB_APPLICATION_LINK)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Application.getAndroidDriver().pressKeyCode(AndroidKeyCode.KEYCODE_BACK);
        return this;
    }

    public boolean isApplicantPageVisible() {
        return getfd().element(By.id("com.peoplematter.android:id/details_fragment_stub")).waitUntil(MAX_TIME)
                .ifElementIsNotDisplayed().isDisplayed();

    }

    public HirePage clickOnI9Button() {
        getfd().element(By.xpath(String.format(I9FORMBUTTON, "I-9"))).getElements().forEach(WebElement::click);
        // getfd().element(By.xpath(I9FORMBUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        // getfd().element(By.xpath(I9FORMTEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;

    }


}
