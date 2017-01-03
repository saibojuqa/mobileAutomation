package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/27/16.
 */
public class whatToExpectPage1 extends BasePage {

    private static final String UNITED_STATES_OF_AMERICA = "//label[@for='selectedUSACountry']";
    private static final String NEXT_BUTTON="moveNextSection";


    public EsignaturePage2 clickOnUSA() {
        getWd().executeScript("arguments[0].click();", getWd().element(By.xpath(UNITED_STATES_OF_AMERICA))
                .getElement());
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new EsignaturePage2();
    }
}