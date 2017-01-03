package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class EducationPage7 extends BasePage {

    private static final String NEXT_BUTTON = "moveNextSection";

    public ResumePage8 clickNextButton() throws InterruptedException {

        Thread.sleep(3000);
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new ResumePage8();


    }
}
