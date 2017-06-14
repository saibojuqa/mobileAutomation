package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import org.apache.poi.ss.formula.functions.T;
import org.jboss.netty.handler.codec.marshalling.ThreadLocalMarshallerProvider;
import org.jboss.netty.handler.codec.spdy.SpdyPingFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by sai.boju on 1/30/17.
 */
public class TimeOffRequestPage extends BasePage {

    private static final String TIMEOFFFRERQUEST_BUTTON = "//android.widget.TextView[@text='Time Off']";
    private static final String PLUS_BUTTON = "com.peoplematter.android:id/fab";
    private static final String STARTS_DAY = "com.peoplematter.android:id/start_date_button";
    private static final String END_DAY = "com.peoplematter.android:id/end_date_button";
    private static final String START_DATE_SELECTOR = "27 July 2017";
    private static final String END_DATE_SELECTOR = "28 July 2017";
    private static final String OK_BUTTON = "//android.widget.Button[@text='OK']";
    private static final String TIMEOFF_REQUESTED_TEXT = "//android.widget.TextView[@text='Time off requested!']";
    private static final String DOUG_BALDWIN_BUTTON = "//android.widget.TextView[@text='Doug Baldwin']";
    private static final String HOME = "//android.widget.TextView[@text='Home']";
    private static final String ARROW_ICON = "com.peoplematter.android:id/icon";
    private static final String APPROVE_BUTTON = "com.peoplematter.android:id/approve_button";
    private static final String DENY_BUTTON = "com.peoplematter.android:id/deny_button";
    private static final String APPROVE_TEXT = "android:id/button2";
    private static final String DENY_TEXT = "android:id/button2";
    private static final String NOTE = "com.peoplematter.android:id/employee_note_layout";
    private static final String YOUR_REPLY_VERIFICATION = "//android.widget.TextView[@text='Your reply']";
    private static final String APPROVING_TIMEOFF_TEXT = "//android.widget.TextView[@text='Approving time off']";
    private static final String APPROVED_TIMEOFF_TEXT = "//android.widget.TextView[@text='Approved time off']";
    private static final String DENIED_TIMEOFF_TEXT = "//android.widget.TextView[@text='Denied time off']";
    private static final String ADDITIONAL_REQUESTS = "com.peoplematter.android:id/list_header_text";
    private static final String FIRST_PENDING_REQUEST = "com.peoplematter.android:id/icon";



    public TimeOffRequestPage clickOnRemoveButton(){
        Application.getAndroidDriver().findElement(By.id("android:id/button2")).click();
        Application.getAndroidDriver().findElement(By.id("com.peoplematter.android:id/dialog_alert_positive")).click();
        return this;
    }





    public static boolean checkElementExist() {
        try {

            WebElement ele = Application.getAndroidDriver().findElement(By.id("//test"));
            System.out.println("If time off bubble is displayed");
            return true;

        } catch (Throwable e) {
        }
        System.out.println("Time Off Bubble Is not displayed");
        return false;
    }

    public TimeOffRequestPage clickOnPlusButton() {

        getfd().element(By.id(PLUS_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage verifyAdditionalRequestsText() {
        getfd().element(By.id(ADDITIONAL_REQUESTS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage verifyApprovedTimeOffText() {
        getfd().element(By.xpath(APPROVED_TIMEOFF_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage verifyDeniedTimeOffRequest() {
        getfd().element(By.xpath(DENIED_TIMEOFF_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage verifyYourReply() {
        getfd().element(By.xpath(YOUR_REPLY_VERIFICATION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage verifyApprovingTimeOffText() {
        getfd().element(By.xpath(APPROVING_TIMEOFF_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage verifyNote() {
        getfd().element(By.id(NOTE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage clickOnDenyText() {
        getfd().element(By.id(DENY_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnApproveText() {
        getfd().element(By.id(APPROVE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnTimeOffRequest() {
        getfd().element(By.xpath(TIMEOFFFRERQUEST_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnStartsDate() throws InterruptedException {
        getfd().element(By.id(STARTS_DAY)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Thread.sleep(3000);
        return this;

    }

    public TimeOffRequestPage swipingVerticalBottomUpUntilTextExists( ) throws InterruptedException {
        WebElement ele1 = Application.getAndroidDriver().findElement(By.name("25 November 2017"));
        boolean x = false;
        while (x == false){

            List<WebElement> ele = Application.getAndroidDriver().findElements(By.className("android.view.View"));
            int size=0;
            size = size+ele.size();
            System.out.println("The total elements is " +size );

            for (int i = 0; i < size; i++) {
                String s;

                if (ele1.isDisplayed()) {

                    x =true;
                    ele1.click();
                    System.out.println(size);
                    break;
                }
            }
            if(!x){
                Dimension size1 =  Application.getAndroidDriver().manage().window().getSize();
                int starty = (int) (size1.height * 0.80);
                int endy = (int) (size1.height * 0.20);
                //Find horizontal point where you wants to swipe. It is in middle of screen width.
                int startx = size1.width / 2;

                Application.getAndroidDriver().swipe(startx, starty, startx, endy, 2000);
            }
        }
        return this;
    }


    public TimeOffRequestPage clickOnEndDate() {
        getfd().element(By.id(END_DAY)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnOKButton() throws InterruptedException {
        Thread.sleep(2000);
        getfd().element(By.xpath(OK_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage verifyTimeOffRequestedText() {
        getfd().element(By.xpath(TIMEOFF_REQUESTED_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public TimeOffRequestPage scrollUntilStartDate() {

        MobileElement abc = (MobileElement) Application.getAndroidDriver()
                .findElement(By.className("android.view.View"));
        abc.swipe(SwipeElementDirection.UP, 25000);
        Application.getAndroidDriver().findElement(By.xpath("//android.view.View[@content-desc='27 July 2017']"))
                .click();
        return this;

    }

    public TimeOffRequestPage clickOnEndDateSelector() {
        Application.getAndroidDriver().findElement(By.xpath("//android.view.View[@content-desc='28 July 2017']"))
                .click();

        return this;

    }
     public TimeOffRequestPage removeTheCreatedTimeOffRequest(){
         List<WebElement> lis = Application.getAndroidDriver().findElements(By.className("android.widget.ImageView"));
         lis.get(0).click();
         Application.getAndroidDriver().findElement(By.id("android:id/button2")).click();
         Application.getAndroidDriver().findElement(By.id("com.peoplematter.android:id/dialog_alert_positive")).click();
         return this;

     }

    public TimeOffRequestPage clickOnDougBaldwinButton() {
        getfd().element(By.name(DOUG_BALDWIN_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnHomeButton() {
        getfd().element(By.xpath(HOME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnFirstPendingRequest() {
         getfd().element(By.id(FIRST_PENDING_REQUEST)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public TimeOffRequestPage clickOnApprovedTimeOffRequestToDelete() throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> aa = Application.getAndroidDriver().findElements(By.id("com.peoplematter.android:id/icon"));
        aa.get(0).click();
        return this;
    }


    public TimeOffRequestPage clickOnSecondPendingRequest() {
        getfd().element(By.id(FIRST_PENDING_REQUEST)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public TimeOffRequestPage clickOnApproveButton() {
        getfd().element(By.id(APPROVE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public TimeOffRequestPage clickOnDenyButton() {
        getfd().element(By.id(DENY_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }
}