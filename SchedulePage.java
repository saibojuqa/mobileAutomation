package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ThreadGuard;

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
    private static final String TENPM_ELEVENTHIRTYPM = "//android.widget.Button[@text ='10:00 PM – 11:30 PM']";
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
    private static final String ONE_SHIFT_OFFER_PENDING_TEXT = "//android.widget.TextView[@text='1 Shift offer pending']";
    private static final String BACK_ARROW_BUTTON = "android.widget.ImageButton";
    private static final String DOUG_BALDWIN = "//android.widget.TextView[@text='Doug Baldwin']";
    private static final String VOLUNTEERS_LIST = "com.peoplematter.android:id/shift_candidates_list_header_text";
    private static final String NOTE_TEXT = "//android.widget.TextView[@text='Note']";
    private static final String DENY_ALL_BUTTON = "com.peoplematter.android:id/shift_candidates_action_all_button";
    private static final String EMPLOYEE_LEVEL = "com.peoplematter.android:id/shift_offer_responses_list_item_ids_employee_level";
    private static final String EMPLOYEE_SCHEDULED_HOURS = "com.peoplematter.android:id/shift_offer_responses_list_item_ids_scheduled_hours";
    private static final String MARY_BALDWIN = "//android.widget.TextView[@text='Mary Baldwin']";



     public SchedulePage clickOnDougBaldwinAndVerifyFields() throws InterruptedException {
         Thread.sleep(2000);
         getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
         getfd().element(By.id(VOLUNTEERS_LIST)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.xpath(NOTE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.id(DENY_ALL_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.id(EMPLOYEE_LEVEL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.id(EMPLOYEE_SCHEDULED_HOURS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         return this;
     }


    public SchedulePage clickOnMaryBaldwinAndVerify() throws InterruptedException {
        Thread.sleep(2000);
        getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Thread.sleep(2000);
        getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        getfd().element(By.xpath(NOTE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        getfd().element(By.id(EMPLOYEE_LEVEL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_details_taker_scheduled_hours_before")).isDisplayed();
        Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_details_taker_scheduled_hours_after")).isDisplayed();
        Application.getAndroidDriver().findElement(By.id("com.peoplematter.android:id/date_section_dates"))
                .isDisplayed();
        Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_details_positive_button"))
                .isDisplayed();
        Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_details_negative_button"))
                .isDisplayed();
        return this;
    }


     public SchedulePage clickOnDenyRequest(){
         //For deny buton
         Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_details_negative_button"))
                        .click();
         //for deny button on the top
         Application.getWebdriver().findElement(By.id("android:id/button2")).isDisplayed();
         //for back button
         Application.getWebdriver().findElement(By.id("android.widget.ImageButton")).isDisplayed();
         getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         return this;
     }

     public SchedulePage clickOnApproveRequest() {
         Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_details_positive_button"))
                 .click();
         Application.getWebdriver().findElement(By.id("android.widget.ImageButton")).isDisplayed();
         getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         return this;
     }

    public SchedulePage clickOnApproveButtonSecondTime(){
        Application.getWebdriver().findElement(By.id("android:id/button2")).click();
        getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_candidates_list_header_text")).isDisplayed();
        getfd().element(By.xpath(NOTE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        Application.getWebdriver().findElement(By.xpath("//android.widget.TextView[@text='Approved by']")).isDisplayed();
        Application.getWebdriver().findElement(By.xpath("//android.widget.TextView[@text='Mobile BusinessUnit']")).isDisplayed();
        Application.getWebdriver().findElement(By.xpath("//android.widget.TextView[@text='Approved shift offer']")).isDisplayed();
        return this;

    }


     public SchedulePage clickOnDenyButtonSecondTime(){
         //tap on deny button
         Application.getWebdriver().findElement(By.id("android:id/button2")).click();
         getfd().element(By.xpath(DOUG_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         getfd().element(By.xpath(MARY_BALDWIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
         // Volunteers available shuld be Zero
          Application.getWebdriver().findElement(By.id("com.peoplematter.android:id/shift_candidates_list_header_text")).isDisplayed();
         getfd().element(By.xpath(NOTE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();

         return this;
     }


    public static boolean checkOfferedNotExist() {
        try {

            WebElement ele = Application.getAndroidDriver().findElement(By.id("//test"));
            System.out.println("If Offered Button is displayed");
            return true;

        } catch (Throwable e) {
        }
        System.out.println("Offered Button Is not displayed");
        return false;
    }

    public SchedulePage clickOnBackArrowButton() {
        getfd().element(By.className(BACK_ARROW_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public SchedulePage clickOnRosterButton() {
        getfd().element(By.xpath(ROSTER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnFridayRoster() {
        getfd().element(By.xpath(FRIDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnThursdayRoster() {
        getfd().element(By.xpath(THURSDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnWednesdayRoster() {
        getfd().element(By.xpath(WEDNESDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnSaturdayRoster() {
        getfd().element(By.xpath(SATURDAY_ROSTER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage clickOnTenPmToElevenThirtyPm() {
        getfd().element(By.xpath(TENPM_ELEVENTHIRTYPM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public SchedulePage verifyShiftOfferPendingText() {
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



    public SchedulePage clickOnScheduleButton() throws InterruptedException {
        Thread.sleep(1000);
        getfd().element(By.xpath(String.format(SCHEDULE_BUTTON, "Schedule"))).getElements().forEach
               (WebElement::click);

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
        Application.getAndroidDriver().hideKeyboard();
        return this;

    }

    public SchedulePage verifyAvailabeBanner() {

        getfd().element(By.id(AVAILABLE_BANNER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public SchedulePage verifyDate() {

       Application.getAndroidDriver().findElement(By.id("com.peoplematter.android:id/date_section_dates"))
               .isDisplayed();
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

    public SchedulePage verifyShiftOfferWithNoVolunteers() {
        getfd().element(By.id(SHIFT_OFFER_WITH_NO_VOLUNTEERS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .isDisplayed();
        return this;
    }

    public SchedulePage verifyOneShiftOfferPendingText() {
        getfd().element(By.xpath(ONE_SHIFT_OFFER_PENDING_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .isDisplayed();
        return this;
    }


}



