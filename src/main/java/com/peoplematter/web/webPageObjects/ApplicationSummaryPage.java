package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/3/17.
 */

    public class ApplicationSummaryPage extends BasePage {

    private static final String SUBMIT = "//input[@type='submit']";

    public ApplicationSummaryPage clickOnSubmitButton() {

        getWd().element(By.xpath(SUBMIT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return this;

    }

 }
