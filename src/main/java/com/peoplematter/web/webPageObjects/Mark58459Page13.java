package com.peoplematter.web.webPageObjects;

import com.peoplematter.web.pojos.UserDetails;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/3/17.
 */
 public class Mark58459Page13 extends BasePage {

    private static final String WOOD = " ";
    private static final String WOODCHUCK = " ";
    private static final String WOODCHUCK_SELECTION = " ";
    private static final String NEXT_BUTTON="moveNextSection";

    public ApplicationSummaryPage selectWoodChuck(UserDetails userDetails){

        getWd().element(By.xpath(WOOD)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().click();
        getWd().element(By.xpath(WOODCHUCK)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().click();
       getWd().element(By.xpath(WOODCHUCK_SELECTION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed();
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

     return new ApplicationSummaryPage();

    }

}
