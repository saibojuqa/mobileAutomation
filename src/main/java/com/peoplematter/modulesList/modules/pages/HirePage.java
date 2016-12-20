package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.util.HashMap;

/**
 * Created by sai.boju on 12/20/16.
 */
public class HirePage extends BasePage {

    private static final String APPLICANT_NAME = "//android.widget.TextView[@text='%s']";
    private static final String VIEW_JOB_APPLICATION_LINK = "//android.widget.TextView[@text='View job application']";


    public HirePage clickOnApplication(String applicantName) {
        getfd().element(By.xpath(String.format(APPLICANT_NAME, applicantName))).waitUntil(MAX_TIME)
                .ifElementIsNotDisplayed().click();
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

}
