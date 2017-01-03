package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/3/17.
 */
public class TaxCreditEligibilityPage12 extends BasePage {

    private static final String NEXT_BUTTON = "moveNextSection";

    public TaxCreditEligibilityPage12 clickOnNextButton() {

        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return new TaxCreditEligibilityPage12();

    }


}
