package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/3/17.
 */
public class TaxCreditEligibilityPage extends BasePage {

    private static final String NEXT_BUTTON = "moveNextSection";

    public Mark58459Page clickOnNextButton() throws InterruptedException {

        Thread.sleep(3000);

        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().bringElementInView().click();

        return new Mark58459Page();

    }


}
