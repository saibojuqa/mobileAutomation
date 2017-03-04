package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/7/16.
 */
public class ManagePage extends BasePage {

    private static final String MILESTONES_BUTTON = "//android.widget.TextView[@text='Milestones']";
    private static final String HOME_BUTTON = "//android.widget.TextView";
    private static final String HOME_BUTTON1 = "com.peoplematter.android:id/icon_text_view";

    private static final String ICON = "//android.widget.TextView[@text='%s']";
    private static final String APPLICANTS_BUTTON = "//android.widget.TextView[@text='Applicants']";
    private static final String CONTACTS_BUTTON = "//android.widget.TextView[@text='Contacts']";
    private static final String CURRENTLY_WORKING_TEXT = "com.peoplematter.android:id/home_today_section_currently_working";
    private static final String COURSES_OVERDUE_TEXT = "com.peoplematter.android:id/home_today_section_overdue_learn";
    private static final String SHIFT_OFFER_TEXT = "com.peoplematter.android:id/home_upcoming_section_shift_offers";
    private static final String TIME_OFFER_TEXT = "com.peoplematter.android:id/home_upcoming_section_pending_time_off";
    private static final String Message_to_Alpharetta_only_RADIOBUTTON = "//android.widget.TextView[@text='Contacts']";
    private static final String VERIFY_COMMENT = "//android.widget.TextView[@text='Hi this is test']";
    private static final String MANAGER_POSTED_NEW_MESSAGE = "//android.widget.TextView[@text='Your manager posted a new message']";
    private static final String MOBILE_BUSINESS_UNIT_EXPAND = "//android.widget.TextView[@text='Mobile BusinessUnit']";
    private static final String BIRTHDAY_AND_HIRED = "//android.widget.TextView[@text='Birthday and hired']";
    private static final String NO_BIRTHDAY_ON_RECORD = "//android.widget.TextView[@text='No birthday on record']";
    private static final String HIRED_AT_WITH_DATE = "//android.widget.TextView[@text='Hired at Alpharetta Location 3:']";


    public ManagePage verifyHiredAtWithPlaceAndDate() {
        getfd().element(By.xpath(BIRTHDAY_AND_HIRED)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getfd().element(By.xpath(HIRED_AT_WITH_DATE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ManagePage verifyNoBirthdayOnRecord() {
        getfd().element(By.xpath(BIRTHDAY_AND_HIRED)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getfd().element(By.xpath(NO_BIRTHDAY_ON_RECORD)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }


    public ManagePage expandMobileBusinessUnit() {
        getfd().element(By.xpath(MOBILE_BUSINESS_UNIT_EXPAND)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public ManagePage verifyYourMAnagerPostedNewMessageText() {
        getfd().element(By.xpath(MANAGER_POSTED_NEW_MESSAGE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .isDisplayed();
        return this;
    }


    public ManagePage verifyComment() {
        getfd().element(By.xpath(VERIFY_COMMENT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ManagePage sendMessageToThatLocationOnly() {
        getfd().element(By.xpath(Message_to_Alpharetta_only_RADIOBUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public ManagePage clickOnMileStonesButton() throws InterruptedException {
        getfd().element(By.xpath(MILESTONES_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public boolean isIconDisplayed(String iconName) throws InterruptedException {
        return getfd().element(By.xpath(String.format(ICON, iconName))).waitUntil(TEN_SECONDS).ifElementIsNotDisplayed()
                .isDisplayed();

    }

    public HirePage clickOnApplicantsButton() throws InterruptedException {
        getfd().element(By.xpath(APPLICANTS_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new HirePage();
    }

    public Homepage clickOnHomeButton() {

        getfd().element(By.xpath(HOME_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getfd().element(By.id(HOME_BUTTON1)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        //getfd().element(By.xpath(String.format(HOME_BUTTON,"Home"))).getElements().forEach(WebElement::click);
        return new Homepage();
    }

    public ManagePage clickOnContactsButton() throws InterruptedException {
        getfd().element(By.xpath(CONTACTS_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public ManagePage verifyCurrentlyWorkingText() {
        getfd().element(By.id(CURRENTLY_WORKING_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ManagePage verifyCoursesOverdueText() {
        getfd().element(By.id(COURSES_OVERDUE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ManagePage verifyShiftOfferText() {
        getfd().element(By.id(SHIFT_OFFER_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public ManagePage verifyTimeOfferText() {
        getfd().element(By.id(TIME_OFFER_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }


}
