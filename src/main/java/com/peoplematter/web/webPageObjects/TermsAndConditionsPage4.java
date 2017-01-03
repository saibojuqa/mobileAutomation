package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/30/16.
 */
public class TermsAndConditionsPage4 extends BasePage {


    private static final String TERMS_AND_CONDITIONS = "//label[contains(@for,'Terms')]";
    private static final String SIGNATURE = "//label[contains(@for,'Signature')]";
    private static final String NEXT_BUTTON = "moveNextSection";

    public DisclosuresPage5 checkTermsAndConditions() {

        getWd().element(By.xpath(TERMS_AND_CONDITIONS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(SIGNATURE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new DisclosuresPage5();

    }


}
