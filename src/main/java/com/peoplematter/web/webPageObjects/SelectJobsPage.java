package com.peoplematter.web.webPageObjects;

import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/27/16.
 */
public class SelectJobsPage extends BasePage{

    private static final String SELECT_JOB = "//label[text()='%s']";
    private static final String NEXT_BUTTON="moveNextSection";

    public IdentificationPage selectJob(String jobName){
        getWd().element(By.xpath(String.format(SELECT_JOB,jobName))).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new IdentificationPage();

    }


}
