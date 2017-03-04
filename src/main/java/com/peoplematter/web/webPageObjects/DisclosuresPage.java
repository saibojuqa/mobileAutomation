package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class DisclosuresPage extends BasePage {

    private static final String BACKGROUND = "//label[contains(@for,'agreedToBackgroundCheckDisclosures')]";
    private static final String NEXT_BUTTON = "moveNextSection";

    public AuthorizationPage clickOnDisclosure() {

        getWd().element(By.xpath(BACKGROUND)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return new AuthorizationPage();


    }


}
