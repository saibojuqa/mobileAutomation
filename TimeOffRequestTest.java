package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 1/30/17.
 */

public class TimeOffRequestTest extends BaseTest {


    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    AppiumDriver driver;

    //59201 - completed
    @Test(priority=0,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void TimeOffCreated(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("TimeOffCreated");
        LoginPage loginPage = new LoginPage();
        Homepage homepage = new Homepage();
        SchedulePage schedulePage = new SchedulePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        TimeOffRequestPage timeOffRequestPage = new TimeOffRequestPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and click Navigate Button ");
        timeOffRequestPage.clickOnTimeOffRequest().clickOnPlusButton().clickOnStartsDate().scrollUntilStartDate()
                .clickOnOKButton().clickOnEndDate().clickOnEndDateSelector().clickOnOKButton();
        logger.log(LogStatus.PASS, "Click On TimeOff Request Button and Click On Plus Button Click On StartDate " +
                "Button and Scroll to Date and Click On Button and Click On End Date Button and Click On Ok");
        schedulePage.enterAComment().clickOnSendButton();
        logger.log(LogStatus.PASS, "Enter a Comment and Click On Send Button");
        timeOffRequestPage.verifyTimeOffRequestedText().clickOnOKButton();
        logger.log(LogStatus.PASS, "To Verify The Validation Error Message is TimeOff Requested Text and Click On OK " +
                "Button");
         timeOffRequestPage.removeTheCreatedTimeOffRequest();
    }

    //106042 - completed
    @Test(priority=1,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void noTimeOffBubble(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("noTimeOffBubble");
        LoginPage loginPage = new LoginPage();
        Homepage homepage = new Homepage();
        SchedulePage schedulePage = new SchedulePage();
        TimeOffRequestPage timeOffRequestPage = new TimeOffRequestPage();
        ManagePage managePage = new ManagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword());
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully");
        timeOffRequestPage.checkElementExist();
        logger.log(LogStatus.PASS, "To Check the Element is present or Not In Timeoff Request Page");
    }

    //59417 - completed
    @Test(priority=2,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void shiftOfferRequestsByManager(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("shiftOfferRequestsByManager");
        LoginPage loginPage = new LoginPage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        ManagePage managePage = new ManagePage();
        TimeOffRequestPage timeOffRequestPage = new TimeOffRequestPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and Click On Navigate Button");
        timeOffRequestPage.clickOnTimeOffRequest().clickOnPlusButton().clickOnStartsDate().scrollUntilStartDate().clickOnOKButton()
                .clickOnEndDate().clickOnEndDateSelector().clickOnOKButton();
        logger.log(LogStatus.PASS, "Click On TimeOff Request Button and Click On Plus Button Click On StartDate " +
                "Button and Scroll to Date and Click On Button and Click On End Date Button and Click On Ok");
        schedulePage.enterAComment().clickOnSendButton();
        logger.log(LogStatus.PASS, "Enter a comment and Click On Send Button");
        timeOffRequestPage.verifyTimeOffRequestedText().clickOnOKButton();
        logger.log(LogStatus.PASS, "To Verify The Validation Error Message is Timeoff Request and Click On Ok Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "To Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMBUAsUNANdPW().clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and Click On Navigate Button and Click On " +
                "Expand Icon");
        timeOffRequestPage.clickOnTimeOffRequest();
        logger.log(LogStatus.PASS, "Click On Timeoff Request");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "Click On Location and Location Name");
        timeOffRequestPage.clickOnFirstPendingRequest().clickOnApproveButton();
        logger.log(LogStatus.PASS, "Click On First Pending Request and Click On Approve Button");
        schedulePage.enterAComment();
        logger.log(LogStatus.PASS, "Enter a Comment");
        timeOffRequestPage.clickOnApproveText().verifyApprovedTimeOffText().verifyAdditionalRequestsText();
        logger.log(LogStatus.PASS, "Click On Approve text and Verify the Validation Error Message is Approved Timeoff" +
                        " Text and Additional Request Text");
        schedulePage.verifyDate().clickOnBackArrowButton();
        logger.log(LogStatus.PASS, "To Verify Validation Date and Click On Back Arrow Button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click On Navigate Button");
        Thread.sleep(2000);
        mbuLearnPage.swipeBottomToTop();
        logger.log(LogStatus.PASS, "To Swipe to Bottom to Top");
        homepage.clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "Click On Sign Out Button and Click On Yes Button");
        loginPage.enterDougAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and Click On Navigate Button");
        timeOffRequestPage.clickOnTimeOffRequest().clickOnApprovedTimeOffRequestToDelete().clickOnRemoveButton();
        logger.log(LogStatus.PASS, "Click On Timeoff Request and Approve Timeoff Request delete Click On Remove " +
                "Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and Click On Navigate Button");
        timeOffRequestPage.clickOnTimeOffRequest().clickOnPlusButton().clickOnStartsDate().scrollUntilStartDate()
                .clickOnOKButton()
                .clickOnEndDate().clickOnEndDateSelector().clickOnOKButton();
        logger.log(LogStatus.PASS, "Click On TimeOff Request Button and Click On Plus Button Click On StartDate " +
                "Button and Scroll to Date and Click On Button and Click On End Date Button and Click On Ok");
        schedulePage.enterAComment().clickOnSendButton();
        logger.log(LogStatus.PASS, "Enter a Comment and Click On Send Button");
        timeOffRequestPage.verifyTimeOffRequestedText().clickOnOKButton();
        logger.log(LogStatus.PASS, "To Verify The Validation Error Message is Timeoff Request and Click On Ok Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMBUAsUNANdPW().clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and Click On Navigate Button and Click On " +
                "Expand Icon");
        timeOffRequestPage.clickOnTimeOffRequest();
        logger.log(LogStatus.PASS, "Click On Timeoff Request");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "Click On Location and Location Name");
        timeOffRequestPage.clickOnSecondPendingRequest().clickOnDenyButton();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "Click On Request Page  and Click On Second Pending Request and Click On Deny " +
                "Button");
        schedulePage.enterAComment();
        logger.log(LogStatus.PASS, "Enter a Comment");
        timeOffRequestPage.clickOnDenyText().verifyDeniedTimeOffRequest().verifyAdditionalRequestsText();
        logger.log(LogStatus.PASS, "Click On Deny Text and Verify The Validation Error Message is Timeoff Request and" +
                " Additional Request Text");
        schedulePage.verifyDate();
        logger.log(LogStatus.PASS, "Verify The Validation Date sucessfully");
    }
}
