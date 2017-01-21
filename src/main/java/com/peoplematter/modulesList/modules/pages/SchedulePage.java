package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/20/17.
 */
public class SchedulePage extends BasePage {

    private static final String ROSTER_BUTTON = "//android.widget.TextView[@text='Roster']";
    private static final String WORKINGNOW_BUTTON = "//android.widget.TextView[@text='Working Now']";
    private static final String SHIFTOFFER_BUTTON = "//android.widget.TextView[@text='Shift Offers']";
    private static final String TIMEOFF_BUTTON = "//android.widget.TextView[@text='Time Off']";


    public SchedulePage clickOnRosterButton() throws InterruptedException {
        Thread.sleep(3000);
        getfd().element(By.xpath(ROSTER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public SchedulePage clickOnWorkingNowButton() throws InterruptedException {
        Thread.sleep(3000);
        getfd().element(By.xpath(WORKINGNOW_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public SchedulePage clickOnShiftOfferButon() throws InterruptedException {
        Thread.sleep(3000);
        getfd().element(By.xpath(SHIFTOFFER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public SchedulePage clickOnTimeoffButton() throws InterruptedException {
        Thread.sleep(3000);
        getfd().element(By.xpath(TIMEOFF_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

}

