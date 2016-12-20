package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;

import static org.openqa.selenium.By.className;

/**
 * Created by sai.boju on 12/7/16.
 */
public class Homepage extends BasePage {


    private static final String HOMEPAGE_CONTAINER = "android.widget.RelativeLayout";
    private static final String NAVIGATE_UP ="android.widget.ImageButton";

    public Homepage() {
        getfd().element(className(HOMEPAGE_CONTAINER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed();
    }

    public OptionsPage clickOnNavigateUpButton(){
        getfd().element(className(NAVIGATE_UP)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new OptionsPage();
    }
}
