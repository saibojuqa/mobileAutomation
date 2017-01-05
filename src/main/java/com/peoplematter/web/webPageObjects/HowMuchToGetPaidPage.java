package com.peoplematter.web.webPageObjects;

import com.peoplematter.web.pojos.UserDetails;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class HowMuchToGetPaidPage extends BasePage{


    private static final String GENERAL = "//label[contains(@for,'answerValue') and contains(text(),'general')" +
            "]/following-sibling::div/input";
    private static final String NUMERIC = "//label[contains(@for,'answerValue') and contains(text(),'numeric')]/following-sibling::div/input";
    private static final String NEXT_BUTTON = "moveNextSection";

    public TellUsAboutYourselfPage enterDetails(UserDetails userDetails) {

        getWd().element(By.xpath(GENERAL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getGeneral());
        getWd().element(By.xpath(NUMERIC)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getNumeric());
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().jsClick();

        return new TellUsAboutYourselfPage();

    }



}
