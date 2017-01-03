package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/30/16.
 */
public class EsignaturePage2 extends BasePage {

    private static final String ESIGNATURE_DISCLOSURE = "//label[@for='agreedToESignatureDisclosuresAndConsent']";
    private static final String TERMSANDCONDITIONS = "//label[@for='agreedToPeopleMatterTermsAndConditions']";
    private static final String NEXT_BUTTON = "moveNextSection";


    public EqualEmploymentPage3 clickOnESIGNATUREANDTERMS() throws InterruptedException {
        Thread.sleep(3000);
        getWd().element(By.xpath(ESIGNATURE_DISCLOSURE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(TERMSANDCONDITIONS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().jsClick();
        return new EqualEmploymentPage3();
    }

}
