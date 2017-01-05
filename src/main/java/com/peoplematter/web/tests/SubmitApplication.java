package com.peoplematter.web.tests;

import com.peoplematter.core.Application;
import com.peoplematter.web.pojos.UserDetails;
import com.peoplematter.web.webPageObjects.GetStartedPage;

/**
 * Created by sai.boju on 12/26/16.
 */
public class SubmitApplication  extends WebBaseTest{

    public void submitUserApplication(UserDetails userDetails) throws InterruptedException {
        setup();
        Application.getWebdriver().get(properties.getProperty("weburl"));
        GetStartedPage getStartedPage=new GetStartedPage();
        getStartedPage.clickOnGetStartedButton().enterLocationDetails(userDetails.getCity(),userDetails.getState(),
                userDetails.getZipcode()).selectLocationAndClickNext(userDetails.getZipcode())
        .selectJob(userDetails.getJobName()).fillIdentificationDetails(userDetails).
                clickOnUSA().clickOnESIGNATUREANDTERMS().selectDropDownValues(userDetails).checkTermsAndConditions()
        .clickOnDisclosure().clickOnAuthorization().clickNextButton().clickOnNextButton().checkAvailability
                (userDetails).enterDetails(userDetails).enterUserDetails(userDetails).clickOnNextButton()
        .selectWoodChuck().clickOnSubmitButton();
        Application.getWebdriver().quit();

    }
}
