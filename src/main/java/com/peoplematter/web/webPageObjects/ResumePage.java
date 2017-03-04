package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class ResumePage extends BasePage {


    private static final String NEXT_BUTTON = ".//*[@id='moveNextSection']";

    public ResumePage clickOnNextButton() throws InterruptedException {

        Thread.sleep(2000);
        getWd().element(By.xpath(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;


    }

}
