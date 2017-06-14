package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ThreadFactory;

/**
 * Created by sai.boju on 1/26/17.
 */
public class ScheduleTest extends BaseTest {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    //58765
    @Test(priority=0,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void cancelPendingShiftOffer(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("cancelPendingShiftOffer");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        Thread.sleep(5000);
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().clickOnSendButton()
                .checkShiftOfferSentText();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Click On Send Button After Check Shift Offer Sent");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button");
        schedulePage.clickOnScheduleButton().checkOfferedTextInBlueColor().clickOnTenPmToElevenThirtyPm().clickOnRemoveText().
                clickOnRemoveButton().verifyTextDisplayed();
        logger.log(LogStatus.PASS, "STEP_5: Click On Schedule Button and Check Offer Text is Color and Click On Ten " +
                "PM To Leven Thirty PM and Click Remove Text and Click Remove Button and Verify the Validation Message");
    }

    //58769 - completed
    @Test(priority=1,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void offerShiftWIthComments(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("offerShiftWIthComments");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().verifyAvailabeBanner().clickOnTenPmToElevenThirtyPm().verifyTextDisplayed().verifyDate()
                .verifyJobPosition();
        logger.log(LogStatus.PASS, "STEP_6: Click On Schedule Button and Verify Validation Message is Availble Banner" +
                " and Click On Ten PM To Leven Thirty PM and Verify Text and Verify Date and Verify Job Position");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_8: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterDougAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_9: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnRemoveText().clickOnRemoveButton();
        logger.log(LogStatus.PASS, "STEP_10: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and " +
                "Verify Text and Click On Remove Text and Click On Remove Button");
    }

    //58782 - completed
    @Test(priority=2,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void acceptShiftOfferwithoutComments(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("acceptShiftOfferwithoutComments");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        Thread.sleep(2000);
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().acceptShift().clickOnSendButton().verifyYouDidText();
        logger.log(LogStatus.PASS, "STEP_6: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and " +
                "Accept Shift Click On Send Button and Verify Vadliadation Message");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_8: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        Thread.sleep(2000);
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_9: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().verifyRequestedText();
        logger.log(LogStatus.PASS, "STEP_10: Click On Schedule Button and Verify the Validation Message");
    }

    //58746 - completed
    @Test(priority=3,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void offerShiftLogInAndOut(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("offerShiftLogInAndOut");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        schedulePage.checkOfferedTextInBlueColor();
        logger.log(LogStatus.PASS, "STEP_4: Check the offerd Text is Blue Color");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_5: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword());
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_6: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Schedule Button");
        schedulePage.checkOfferedTextInBlueColor().clickOnTenPmToElevenThirtyPm().clickOnRemoveText().clickOnRemoveButton();
        logger.log(LogStatus.PASS, "STEP_8: Checked Offer Text is Blue Color and Click On 10 PM to 11:30 PM and Click" +
                " On Remove Text and Click On Remove Button");

    }

    //58730 - completed
    @Test(priority=4,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void viewScheduleWithOfferedAndAvailableShifts(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("viewScheduleWithOfferedAndAvailableShifts");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button");
        schedulePage.clickOnScheduleButton().checkOfferedTextInBlueColor().verifyAvailabeBanner().clickOnTenPmToElevenThirtyPm()
                .clickOnRemoveText().clickOnRemoveButton();
        logger.log(LogStatus.PASS, "STEP_5: Click On Schedule Button and  Checked Offer Text is Blue ColorAvailble Verify Validation Message isBanner" +
                " and Click On Ten PM To Leven Thirty PM and Click  On Remove Text and Click On Remove Button");

    }

    //58731 - completed
    @Test(priority=5,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void viewScheduleWhenShiftOfferedByOthers(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("viewScheduleWhenShiftOfferedByOthers");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click on Navigate Button ");
        schedulePage.clickOnScheduleButton().verifyAvailabeBanner();
        logger.log(LogStatus.PASS, "STEP_6: Click On Schedule Button and Verify the Available Banner");
    }

    //59199- completed
    @Test(priority=6,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider ="excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void shiftOfferCreated(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("shiftOfferCreated");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        Thread.sleep(5000);
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        schedulePage.clickOnRemoveText().clickOnRemoveButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Remove Text and Click On Remove Button");
    }

    //58921 - completed
    @Test(priority=7,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void rosterOfferedShift(Map<String, String> testData) throws IOException {
        logger = report.startTest("rosterOfferedShift");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnRosterButton().clickOnSaturdayRoster().clickOnTenPmToElevenThirtyPm().clickOnOfferButton()
                .enterAComment().clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        schedulePage.verifyShiftOfferPendingText();
        logger.log(LogStatus.PASS, "STEP_4: Verify the Validation Error Message Shift Offer Pending Text");

    }

    //58922-completed
    @Test(priority=8,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void colleagueRescindsShift(Map<String, String> testData) throws IOException {
        logger = report.startTest("colleagueRescindsShift");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnRosterButton().clickOnSaturdayRoster().clickOnTenPmToElevenThirtyPm().clickOnOfferButton()
                .enterAComment().clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Roster Button and Click On Saturday Roster Button Click On Ten " +
                "PM " +
                "To Leven Thirty PM and Click On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        schedulePage.verifyShiftOfferPendingText();
        logger.log(LogStatus.PASS, "STEP_4: Verify the Validation Error Message Shift Offer Pending Text");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_5: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_6: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnSaturdayRoster().clickOnTenPmToElevenThirtyPm().acceptShift().enterAComment
                ().clickOnSendButton().verifyYouDidText();
        logger.log(LogStatus.PASS, "STEP_7: Click On Roster Button and Click On Saturday Roster Button Click On Ten " +
                "PM " +
                "To Leven Thirty PM and Click On Offer Button and Enter a Comment and Verify Validation Message");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_8: Click On Back Button");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_9: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_10: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_11: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnRosterButton().clickOnSaturdayRoster().clickOnTenPmToElevenThirtyPm().clickOnRemoveText()
                .clickOnRemoveButton();
        logger.log(LogStatus.PASS, "STEP_12: Click On Roster Button and Click On Saturday Roster Button Click On Ten " +
                "PM" +
                " To Leven Thirty PM and Click On Remov Text and Click On Remove Button");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_13: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_14: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_15: Enter un,pw and login sucessfully and click Navigate Button ");
        schedulePage.clickOnRosterButton().clickOnSaturdayRoster().checkOfferedNotExist();
        logger.log(LogStatus.PASS, "STEP_16: Click On Roster Button and Click On Saturday Roster Button and Check the" +
                " " +
                "Offerd Not Displayed");
    }


    //65368 - completed
    @Test(priority=9,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void switchingBetweenNoShiftOfferToShiftOffer(Map<String, String> testData) throws IOException {
        logger = report.startTest("switchingBetweenNoShiftOfferToShiftOffer");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnRosterButton().clickOnWednesdayRoster().clickOnThursdayRoster().clickOnFridayRoster()
                .clickOnSaturdayRoster();
        logger.log(LogStatus.PASS, "STEP_2: Click On Roster Button and Click On WednesDay Roster Button and Click On " +
                "ThursDay Roster Button and Click On Friday Roster Button and Click On Saturday Roster Button");

    }

    //59132 - completed
    @Test(priority=10,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void increaseInShiftOfferVolunteers(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("increaseInShiftOfferVolunteers");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click Navigate Button");
        managePage.clickOnHomeButton();
        logger.log(LogStatus.PASS, "STEP_6: Click On Home Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "STEP_7: Click On Location and Location Name");
        schedulePage.verifyShiftOfferWithNoVolunteers();
        logger.log(LogStatus.PASS, "STEP_8: Verify the Validation Shift Offer With No Of Volunteers Message");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_9: Click On Navigate Button");
        mbuLearnPage.swipeBottomToTop();
        logger.log(LogStatus.PASS, "STEP_10: Swipe to Buttom to Top");
        homepage.clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_11: Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW();
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_12: Enter un,pw and login sucessfully and click Navigate Button");
        //loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().acceptShift().clickOnSendButton().verifyYouDidText();
        logger.log(LogStatus.PASS, "STEP_13: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and " +
                "Accept Shift and Click On Send Button and Verify Valiadtion Message");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_14: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_15: Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "STEP_16: Enter un,pw and login sucessfully and click Navigate Button");
        managePage.clickOnHomeButton();
        logger.log(LogStatus.PASS, "STEP_17: Click On Home Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "STEP_18: Click On Location and Location Name");
        schedulePage.verifyOneShiftOfferPendingText();
        logger.log(LogStatus.PASS, "STEP_19: Verify the Validation Shift Offer Pending Text Message");
    }


    //58817 - complated
    @Test(priority=11,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void shiftOfferPushNotification(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("shiftOfferPushNotification");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On 10pm and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().verifyAvailabeBanner();
        logger.log(LogStatus.PASS, "STEP_6: Click On Schedule Button and Verify Validation Availble Banner Message");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterDougAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_8: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnRemoveText().clickOnRemoveButton();
        logger.log(LogStatus.PASS, "STEP_9: Click On Schedule Button and Click On 10PM and Click" +
                " On Remove Text and Click On Remove  Button");
    }


    //58840 - completed
    @Test(enabled = false,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class,
            dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void denyAShiftOfferRequest(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("denyAShiftOfferRequest");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().acceptShift().clickOnSendButton().verifyYouDidText();
        logger.log(LogStatus.PASS, "STEP_6: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and " +
                "Accept Shift and Click On Send Button and Verify Validation Message");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_8: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMBUAsUNANdPW();
        logger.log(LogStatus.PASS, "STEP_9: Enter un,pw and login sucessfully");
        homepage.clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "STEP_10: Click On Navigate Button and Expand Manage Options");
        schedulePage.clickOnShiftOfferButon();
        logger.log(LogStatus.PASS, "STEP_11: Click On Shift Offer Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "STEP_12: Click On Location and Location Name Button");
        schedulePage.clickOnDougBaldwinAndVerifyFields().clickOnMaryBaldwinAndVerify().clickOnDenyRequest().clickOnDenyButtonSecondTime();
        logger.log(LogStatus.PASS, "STEP_13: Click On DougBaldwin and Verify Fields and Click On Deny Request Click " +
                "On Deny Button Second Time");
    }


    //58839
    @Test(enabled = false,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class,
            dataProvider =
            "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void ApproveAShiftOfferRequest(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("ApproveAShiftOfferRequest");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        logger.log(LogStatus.PASS, "STEP_2: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and Click" +
                " On Offer Button and Enter a Comment and Click On Send Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_3: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_4: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_5: Enter un,pw and login sucessfully and click Navigate Button");
        schedulePage.clickOnScheduleButton().clickOnTenPmToElevenThirtyPm().acceptShift().clickOnSendButton().verifyYouDidText();
        logger.log(LogStatus.PASS, "STEP_6: Click On Schedule Button and Click On Ten PM To Leven Thirty PM and " +
                "Accept Shift and Click On Send Button and Verify Validation Message");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Back Button");
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "STEP_8: Click On Navigate Button and Click On Sign Out Button and Click On Yes Button");
        loginPage.enterMBUAsUNANdPW();
        logger.log(LogStatus.PASS, "STEP_9: Enter un,pw and login sucessfully");
        homepage.clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "STEP_10: Click On Navigate Button and Expand Manage Options");
        schedulePage.clickOnShiftOfferButon();
        logger.log(LogStatus.PASS, "STEP_11: Click On Shift Offer Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "STEP_12: Click On Location and Location Name Button");
        schedulePage.clickOnDougBaldwinAndVerifyFields().clickOnMaryBaldwinAndVerify().clickOnApproveRequest()
                .clickOnApproveButtonSecondTime();
        logger.log(LogStatus.PASS, "STEP_13: Click On DougBaldwin and Verify Fields and Click On Approve Request " +
                "Click On Approve Button Secon Time");

    }
}