package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/3/17.
 */
public class Mark58459Page extends BasePage {

    private static final String WOODTRUE = "//label[contains(@for,'True')]";
    private static final String WOODFALSE = "//label[contains(@for,'False')]";
    private static final String WOODCHUCK = "//div[@class='ui-select']/a ";
    private static final String WOODCHUCK_SELECTION = "//a[text()='1 cord']";
    private static final String NEXT_BUTTON = "moveNextSection";

    public ApplicationSummaryPage selectWoodChuck() {
        getWd().element(By.xpath(WOODTRUE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(WOODCHUCK)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(WOODCHUCK_SELECTION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath("//a[text()='Close']")).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).bringElementInView().click();
        return new ApplicationSummaryPage();

    }

}
