package com.peoplematter.modulesList.modules.pages;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/7/16.
 */
public class OptionsPage extends Homepage {

    private static final String MANAGE_OPTIONS_ICON = "//android.widget.TextView[@text='Manage']";
    private static final String ACTION_ITEMS_LINK = PACKAGE_NAME + "id/drawer_ids_action_items";


    public ManagePage expandManageOptions() throws InterruptedException {
        Thread.sleep(2000);
        getfd().element(By.xpath(MANAGE_OPTIONS_ICON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new ManagePage();
    }

    public ActionItemsPage clickOnActionItems() {
        getfd().element(By.id(ACTION_ITEMS_LINK)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new ActionItemsPage();
    }
}
