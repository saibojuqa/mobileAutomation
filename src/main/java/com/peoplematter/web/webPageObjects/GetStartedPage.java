package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/26/16.
 */
public class GetStartedPage extends BasePage {

    private static final String GET_STARTED_BUTTON = "GetStartedPage-GetStartedButton";

    public BusinessUnitsPage clickOnGetStartedButton() {
        getWd().element(By.id(GET_STARTED_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new BusinessUnitsPage();
    }

}
