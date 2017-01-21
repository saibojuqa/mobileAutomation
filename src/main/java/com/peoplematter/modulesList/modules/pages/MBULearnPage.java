package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/20/17.
 */
public class MBULearnPage extends BasePage {


    private static final String COURSES_BUTTON = "//android.widget.TextView[@text='Courses']";
    private static final String OVERDUE_TEXT = "//android.widget.TextView[@text='Overdue']";
    private static final String COMPLETED_BUTTON = "//android.widget.TextView[@text='Completed']";
    private static final String WITHINLAST7DAYS_TEXT = "//android.widget.TextView[@text='Within last 7 days']";

    public MBULearnPage clickOnCourseButton() throws InterruptedException{
Thread.sleep(3000);
        getfd().element(By.xpath(COURSES_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public MBULearnPage checkOverdueText() throws InterruptedException {
Thread.sleep(3000);
        getfd().element(By.xpath(OVERDUE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public MBULearnPage clickOnCompletedButton() throws InterruptedException{
Thread.sleep(3000);
        getfd().element(By.xpath(COMPLETED_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

  public MBULearnPage checkWithinLast7DaysText() throws InterruptedException {
Thread.sleep(3000);
        getfd().element(By.xpath(WITHINLAST7DAYS_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

}
