package com.peoplematter.web.webPageObjects;

import com.peoplematter.core.Application;
import com.peoplematter.web.pojos.UserDetails;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class YourAvailabilityPage extends BasePage {


    private static final String HOURS_PER_WEEK = "//label[contains(@for,'hoursPerWeek')]/following-sibling::div/input";
    private static final String AVAILABILITY = "//label[contains(@for,'availableAllWeek') and contains(text(),'all " +
            "week')]";
    private static final String MONTH = "availableDate-cmbMonth";
    private static final String DAY = "availableDate-cmbDay";
    private static final String YEAR = "availableDate-cmbYear";
    private static final String NOTICE_PERIOD = "//label[contains(@for,'Length')]/following-sibling::div/a";
    private static final String NOTICE_PERIOD_SELECTION = "//a[text()='%s']";
    private static final String NEXT = "moveNextSection";

    public YourAvailabilityPage checkAvailability(UserDetails userDetails) {

        getWd().element(By.xpath(HOURS_PER_WEEK)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys
                (userDetails.getHours());
        getWd().element(By.xpath(AVAILABILITY)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().select(By.id(MONTH)).selectByText(userDetails.getStartMonth());
        getWd().select(By.id(DAY)).selectByText(userDetails.getStartDay());
        getWd().select(By.id(YEAR)).selectByText(userDetails.getStartYear());
        getWd().element(By.xpath(NOTICE_PERIOD)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(String.format(NOTICE_PERIOD_SELECTION, userDetails.getNoticePeriod()))).waitUntil(MAX_TIME)
                .ifElementIsNotDisplayed().click();

        Application.getWebdriver().findElement(By.id("moveNextSection")).click();
        //  getWd().element(By.id(NEXT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }

}
