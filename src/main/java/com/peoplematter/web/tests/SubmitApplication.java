package com.peoplematter.web.tests;

import com.peoplematter.core.Application;
import com.peoplematter.web.pojos.UserDetails;
import com.peoplematter.web.webPageObjects.*;

import java.awt.*;

/**
 * Created by sai.boju on 12/26/16.
 */
public class SubmitApplication extends WebBaseTest {

    public void submitUserApplication(UserDetails userDetails) throws InterruptedException, AWTException {
        setup();
        Application.getWebdriver().get(properties.getProperty("weburl"));
        GetStartedPage getStartedPage = new GetStartedPage();
        YourAvailabilityPage yourAvailabilityPage = new YourAvailabilityPage();
        ResumePage resumePage = new ResumePage();
        TellUsAboutYourselfPage tellUsAboutYourselfPage = new TellUsAboutYourselfPage();
        EducationPage educationPage = new EducationPage();
        getStartedPage.clickOnGetStartedButton().enterLocationDetails(userDetails.getCity(), userDetails.getState(),
                userDetails.getZipcode()).selectLocationAndClickNext(userDetails.getZipcode())
                .selectJob(userDetails.getJobName()).fillIdentificationDetails(userDetails).
                clickOnUSA().clickOnESIGNATUREANDTERMS().selectDropDownValues(userDetails).checkTermsAndConditions();

        // .clickOnDisclosure().clickOnAuthorization();
        educationPage.scrollUntilNext();
        resumePage.clickOnNextButton();
        yourAvailabilityPage.checkAvailability(userDetails);
        //enterDetails(userDetails).
        tellUsAboutYourselfPage.enterUserDetails(userDetails).clickOnNextButton()
                .selectWoodChuck().clickOnSubmitButton();
//        Application.getWebdriver().quit();

    }
}
