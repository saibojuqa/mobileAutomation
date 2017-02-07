package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import javax.smartcardio.ATR;

/**
 * Created by sai.boju on 2/1/17.
 */
public class RecruitingPage extends BasePage {


    private static final String REQUISITION_BUTTON = "//android.widget.TextView[@text='%s']";
    private static String PENDING_REQUISITION = "com.peoplematter.android:id/item_container";
    private static String STATUS_BUTTON = "android.widget.TextView=[@text='Status: Pending']";
    private static String VERIFY_BACK_BUTTON = "//android.widget.ImageButton";
    private static String VERIFY_SAVE_BUTTON = "//android.widget.TextView[@text='Save']";
    private static String REQUISITION_NUMBER = "com.peoplematter.android:id/req_number";
    private static String PENDING_BUTTON = "//android.widget.RadioButton[@text='Pending']";
    private static String OPEN_BUTTON = "//android.widget.RadioButton[@text='Open']";
    private static String NO_RADIO_BUTTON = "//android.widget.RadioButton[@text='No']";
    private static String YES_RADIO_BUTTON = "//android.widget.RadioButton[@text='Yes']";
    private static String ALL_OPEN_BUTTON = "//android.widget.RadioButton[@text='All open']";
    private static String ALL_PENDING_BUTTON = "//android.widget.RadioButton[@text='All pending']";


   public RecruitingPage clockOnAllOpenButton(){
    getfd().element(By.xpath(ALL_OPEN_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
       return this;
   }

    public RecruitingPage clickOnAllPendingButton(){
        getfd().element(By.xpath(ALL_PENDING_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public RecruitingPage clickOnRequisitionButton(){
    getfd().
    element(By.xpath(String.format(REQUISITION_BUTTON, "Schedule"))).getElements().forEach(WebElement::click);
    return this;
}


    public RecruitingPage clickOnPendingRequisition(){
        getfd().element(By.id(PENDING_REQUISITION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public RecruitingPage clickOnStatusButton(){
        getfd().element(By.xpath(STATUS_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public RecruitingPage verifyBackButton()  {
        getfd().element(By.xpath(VERIFY_BACK_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public RecruitingPage verifySaveButton(){
        getfd().element(By.xpath(VERIFY_SAVE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }

    public RecruitingPage verifyRequisitionNumber(){
        getfd().element(By.xpath(REQUISITION_NUMBER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().isDisplayed();
        return this;
    }


    public RecruitingPage clickOnPendingbutton(){
        getfd().element(By.xpath(PENDING_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public RecruitingPage clickOnOpenButton(){
        getfd().element(By.xpath(OPEN_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public RecruitingPage clickOnNoRadioButton(){
        getfd().element(By.xpath(NO_RADIO_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public RecruitingPage clickOnYesRadioButton(){
        getfd().element(By.xpath(YES_RADIO_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

}
