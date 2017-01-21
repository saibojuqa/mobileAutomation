package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

/**
 * Created by sai.boju on 12/7/16.
 */
public class Homepage extends BasePage {


    private static final String HOMEPAGE_CONTAINER = "android.widget.RelativeLayout";
    private static final String NAVIGATE_UP = "android.widget.ImageButton";
    private static final String DATE = "com.peoplematter.android:id/home_section_title";
    private static final String UPCOMING_TEXT = "//android.widget.TextView[@text='Upcoming']";
    private static final String APPLICANTS_TAB = "//android.widget.TextView[@text='Applicants']";
    private static final String APPLICANTSLAST14DAYS= "//android.widget.TextView[@text='Applicants Last 14 Days']";

    public Homepage() {
        getfd().element(className(HOMEPAGE_CONTAINER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed();
    }

    public OptionsPage clickOnNavigateUpButton() {
        getfd().element(className(NAVIGATE_UP)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new OptionsPage();
    }

    public boolean isDateVisible() {
        return getfd().element(id(DATE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
    }

    public boolean isUpcomingTextVisible() {
        return getfd().element(xpath(UPCOMING_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
    }

    public Homepage clickOnApplicantsTab() {
        getfd().element(xpath(APPLICANTS_TAB)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public boolean isApplicantsInLast14DaysVisible() {
        return getfd().element(xpath(APPLICANTSLAST14DAYS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
    }

}






