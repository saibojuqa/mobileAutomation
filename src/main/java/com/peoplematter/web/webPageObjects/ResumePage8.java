package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/2/17.
 */
public class ResumePage8 extends BasePage{


    private static final String NEXT_BUTTON = "moveNextSection";

    public YourAvailabilityPage9 clickOnNextButton() throws InterruptedException {

        Thread.sleep(3000);
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new YourAvailabilityPage9();


    }

}
