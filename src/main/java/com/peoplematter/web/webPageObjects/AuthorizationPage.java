package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class AuthorizationPage extends BasePage{


    private static final String AUTHORIZATION = "//label[contains(@for,'agreedToBackgroundCheckAuthorization')]";
    private static final String CALIFORNIA_LAW = "//label[contains(@for,'requestsCopyOfReport')]";
    private static final String NEXT_BUTTON="moveNextSection";

    public EducationPage clickOnAuthorization() {

        getWd().element(By.xpath(AUTHORIZATION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(CALIFORNIA_LAW)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return new EducationPage();




    }



}
