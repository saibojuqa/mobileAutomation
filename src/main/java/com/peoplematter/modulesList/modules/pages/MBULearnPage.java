package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


/**
 * Created by sai.boju on 1/20/17.
 */
public class MBULearnPage extends BasePage {


    private static final String COURSES_BUTTON = "//android.widget.TextView[@text='Courses']";
    private static final String OVERDUE_TEXT = "//android.widget.TextView[@text='Overdue']";
    private static final String COMPLETED_BUTTON = "//android.widget.TextView[@text='Completed']";
    private static final String WITHINLAST7DAYS_TEXT = "//android.widget.TextView[@text='Within last 7 days']";
    private static final String MOBILEBUSINESSUNIT = "//android.widget.TextView[@text='Mobile BusinessUnit']";

    public MBULearnPage clickOnCourseButton() throws InterruptedException {


        getfd().element(By.xpath(MOBILEBUSINESSUNIT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        swipeBottomToTop();
        getfd().element(By.xpath(COURSES_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public MBULearnPage checkOverdueText() {
        getfd().element(By.xpath(OVERDUE_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public MBULearnPage clickOnCompletedButton() throws InterruptedException {

        swipeBottomToTop();
        getfd().element(By.xpath(COMPLETED_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

    public MBULearnPage checkWithinLast7DaysText() {
        getfd().element(By.xpath(WITHINLAST7DAYS_TEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public void swipeBottomToTop() throws InterruptedException {

        Dimension size = Application.getAndroidDriver().manage().window().getSize();

        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top.
        Application.getAndroidDriver().swipe(startx, starty, startx, endy, 2000);
        Thread.sleep(2000);

    }


    public void swipeTopToBottom() throws InterruptedException {

        Dimension size = Application.getAndroidDriver().manage().window().getSize();

        System.out.println(size);

        //Find swipe start and end point from screen's with and height.
        //Find starty point which is at bottom side of screen.
        int starty = (int) (size.height * 0.80);
        //Find endy point which is at top side of screen.
        int endy = (int) (size.height * 0.20);
        //Find horizontal point where you wants to swipe. It is in middle of screen width.
        int startx = size.width / 2;
        System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

        //Swipe from Bottom to Top.
        Application.getAndroidDriver().swipe(startx, endy, startx, starty, 3000);
        Thread.sleep(2000);

    }


}
