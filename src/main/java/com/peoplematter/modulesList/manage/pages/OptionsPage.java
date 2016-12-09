package com.peoplematter.modulesList.manage.pages;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/7/16.
 */
public class OptionsPage extends Homepage {

    private static final String MANAGE_OPTIONS_ICON = "//android.widget.TextView[@text='Manage']";



    public ManagePage expandManageOptions() {
        getfd().element(By.xpath(MANAGE_OPTIONS_ICON)).waitUntil(MAX_TIME)
                .ifElementIsNotDisplayed().click();
        return new ManagePage();
    }
}
