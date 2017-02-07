package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import com.sun.webkit.ContextMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by sai.boju on 1/20/17.
 */
public class SchedulePage extends BasePage {

    private static final String ROSTER_BUTTON = "//android.widget.TextView[@text='Roster']";
    private static final String WORKINGNOW_BUTTON = "//android.widget.TextView[@text='Working Now']";
    private static final String SHIFTOFFER_BUTTON = "//android.widget.TextView[@text='Shift Offers']";
    private static final String TIMEOFF_BUTTON = "//android.widget.TextView[@text='Time Off']";
    private static final String SCHEDULE_BUTTON = "//android.widget.TextView[@text='%s']";
    private static final String TBD_BUTTON = "//android.widget.Button[@text ='6:00 AM – TBD']";
    private static final String EIGHTAM_NINEPM = "//android.widget.Button[@text ='8:00 AM – 9:00 PM']";
    private static final String OFFER_BUTTON = "//android.widget.TextView[@text='Offer']";
    private static final String SEND_BUTTON = "//android.widget.TextView[@text='Send']";
    private static final String SHIFT_OFFER_SENT_TEXT = "//android.widget.TextView[@text='Shift offer sent!']";
    private static final String REMOVE_TEXT = "//android.widget.TextView[@text='Remove']";
    private static final String OFFERED_TEXT = "//android.widget.TextView[@text='Offered']";
    private static final String REMOVE_BUTTON = "com.peoplematter.android:id/dialog_alert_positive";
    private static final String VERIFY_TEXT = "com.peoplematter.android:id/text_section_text_1";
    private static final String ENTER_A_COMMENT = "com.peoplematter.android:id/english_comment_box";
    private static final String AVAILABLE_BANNER = "com.peoplematter.android:id/banner_text";
    private static final String DATE_TEXT = "com.peoplematter.android:id/shift_details_date";
    private static final String JOB_POSITION = "//android.widget.TextView[@text='Cook']";
    private static final String ILDOIT_BUTTON = "android:id/button2";
    private static final String YOU_DONE_IT_TEXT = "com.peoplematter.android:id/text_section_header";
    private static final String REQUESTED_TEXT = "//android.widget.TextView[@text='Requested']";
    private static final String FIVEAM_SIXPM = "//android.widget.Button[@text='5:00 AM – 6:00 PM']";
    private static final String FRIDAY_ROSTER = "//android.widget.TextView[@text='Fri']";
    private static final String SHIFT_OFFER_PENDING_TEXT = "//android.widget.TextView[@text='Shift offer pending']";
    private static final String THURSDAY_ROSTER = "//android.widget.TextView[@text='Thu']";
    private static final String WEDNESDAY_ROSTER = "//android.widget.TextView[@text='Wed']";
    private static final String SATURDAY_ROSTER = "//android.widget.TextView[@text='Sat']";
    private static final String SHIFT_OFFER_WITH_NO_VOLUNTEERS = "com.peoplematter.android:id/home_upcoming_section_shift_offers";
    private static final String ONE_SHIFT_OFFER_PENDING_TEXT = "//android.widget.TextView[@text='1 Shift offer " +
            "pending']";

    public SchedulePage clickOnRosterButton() {
        getfd().element(By.xpath(ROSTER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnFridayRoster(){
        getfd().element(By.xpath(FRIDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnThursdayRoster(){
        getfd().element(By.xpath(THURSDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnWednesdayRoster(){
        getfd().element(By.xpath(WEDNESDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnSaturdayRoster(){
        getfd().element(By.xpath(SATURDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnEightAmToNinePm() {
        getfd().element(By.xpath(EIGHTAM_NINEPM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage verifyShiftOfferPendingText(){
        getfd().element(By.xpath(SHIFT_OFFER_PENDING_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }


    public SchedulePage clickOnWorkingNowButton() {
        getfd().element(By.xpath(WORKINGNOW_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public SchedulePage clickOnShiftOfferButon() {
        getfd().element(By.xpath(SHIFTOFFER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public SchedulePage clickOnTimeoffButton() {
        getfd().element(By.xpath(TIMEOFF_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnScheduleButton() {
        getfd().element(By.xpath(String.format(SCHEDULE_BUTTON, "Schedule"))).getElements().forEach
                (WebElement::click);

        // getfd().element(By.xpath(SCHEDULE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public SchedulePage clickOnTBDButton() {
        getfd().element(By.xpath(TBD_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public SchedulePage clickOnOfferButton() {
        getfd().element(By.xpath(OFFER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public SchedulePage clickOnSendButton() {

        getfd().element(By.xpath(SEND_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public SchedulePage checkShiftOfferSentText() {
        getfd().element(By.xpath(SHIFT_OFFER_SENT_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage clickOnRemoveText() {

        //  getfd().element(By.xpath(String.format(REMOVE_TEXT,"Remove"))).getElements().forEach
        //        (WebElement::click);

        getfd().element(By.xpath(REMOVE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage checkOfferedTextInBlueColor() {

        getfd().element(By.xpath(OFFERED_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage clickOnRemoveButton() {

        getfd().element(By.id(REMOVE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage verifyTextDisplayed() {

        getfd().element(By.id(VERIFY_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage enterAComment() {

        getfd().element(By.id(ENTER_A_COMMENT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("Hi this is test");
        return this;

    }

    public SchedulePage verifyAvailabeBanner() {

        getfd().element(By.id(AVAILABLE_BANNER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage verifyDate() {

        getfd().element(By.id(DATE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage verifyJobPosition() {

        getfd().element(By.xpath(JOB_POSITION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage acceptShift() {
        getfd().element(By.id(ILDOIT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public SchedulePage verifyYouDidText() {
        getfd().element(By.id(YOU_DONE_IT_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;

    }

    public SchedulePage verifyRequestedText() {
        getfd().element(By.xpath(REQUESTED_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

public SchedulePage clickOnFiveAmToSixAm() {

    // getfd().element(By.xpath(String.format(FIVEAM_SIXPM, "5:00 AM – 6:00 PM"))).getElements().forEach
          //   (WebElement::click);

   getfd().element(By.xpath(FIVEAM_SIXPM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
    return this;

}
    public static boolean checkOfferedNotExist()
    {
        try{

            WebElement ele= Application.getAndroidDriver().findElement(By.id("//test"));
            System.out.println("If Offered Button is displayed");
            return true;

        }catch(Throwable e){}
        System.out.println("Offered Button Is not displayed");
        return false;
    }

    public SchedulePage verifyShiftOfferWithNoVolunteers(){
        getfd().element(By.id(SHIFT_OFFER_WITH_NO_VOLUNTEERS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .isDisplayed();
        return this;
    }

    public SchedulePage verifyOneShiftOfferPendingText(){
        getfd().element(By.xpath(ONE_SHIFT_OFFER_PENDING_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .isDisplayed();
        return this;
    }


}



