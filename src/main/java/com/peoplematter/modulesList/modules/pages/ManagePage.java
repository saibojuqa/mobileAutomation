package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/7/16.
 */
public class ManagePage extends BasePage {

    private static final String MILESTONES_BUTTON = "//android.widget.TextView[@text='Milestones']";
    private static final String HOME_BUTTON = "//android.widget.TextView[@text='Home']";
    private static final String ICON = "//android.widget.TextView[@text='%s']";
    private static final String APPLICANTS_BUTTON = "//android.widget.TextView[@text='Applicants']";
    private static final String CONTACTS_BUTTON = "//android.widget.TextView[@text='Contacts']";


    public  ManagePage clickOnMileStonesButton() throws InterruptedException{
        Thread.sleep(3000);
        getfd().element(By.xpath(MILESTONES_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public boolean isIconDisplayed(String iconName)throws InterruptedException{
        Thread.sleep(3000);
        return getfd().element(By.xpath(String.format(ICON,iconName))).waitUntil(TEN_SECONDS).ifElementIsNotDisplayed()
                .isDisplayed();

    }

    public  HirePage clickOnApplicantsButton() throws InterruptedException{
        Thread.sleep(3000);
        getfd().element(By.xpath(APPLICANTS_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new HirePage();
    }

    public  Homepage clickOnHomeButton() throws InterruptedException {
        Thread.sleep(3000);
        getfd().element(By.xpath(HOME_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new Homepage();
    }
    public  ManagePage clickOnContactsButton() throws InterruptedException {
        Thread.sleep(3000);
        getfd().element(By.xpath(CONTACTS_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }



}
