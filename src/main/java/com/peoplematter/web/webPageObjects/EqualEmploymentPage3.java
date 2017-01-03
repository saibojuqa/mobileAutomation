package com.peoplematter.web.webPageObjects;

import com.peoplematter.web.pojos.UserDetails;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/30/16.
 */
public class EqualEmploymentPage3 extends BasePage {

    private static final String RACE_BUTTON = "//div[@name='ethnicity']/descendant::a";
    private static final String RACE_SELECTION = "//a[text()='%s']";
    private static final String GENDER_BUTTON = "//div[@name='gender']/descendant::a";
    private static final String GENDER_SELECTION = "//a[text()='%s']";
    private static final String NEXT_BUTTON = "moveNextSection";

    public TermsAndConditionsPage4 selectDropDownValues(UserDetails userDetails) {

        getWd().element(By.xpath(RACE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(String.format(RACE_SELECTION, userDetails.getRace()))).waitUntil(MAX_TIME)
                .ifElementIsNotDisplayed().click();

        getWd().element(By.xpath(GENDER_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(String.format(GENDER_SELECTION, userDetails.getGender()))).waitUntil(MAX_TIME)
                .ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return new TermsAndConditionsPage4();
    }


}
