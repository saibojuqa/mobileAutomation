package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 1/26/17.
 */
public class ScheduleTest extends BaseTest {


    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    //58765 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void cancelPendingShiftOffer(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().clickOnSendButton()
                .checkShiftOfferSentText();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().checkOfferedTextInBlueColor().clickOnFiveAmToSixAm().clickOnRemoveText().
                clickOnRemoveButton().verifyTextDisplayed();
    }


    //58769 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void offerShiftWIthComments(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().verifyAvailabeBanner().clickOnFiveAmToSixAm().verifyTextDisplayed().verifyDate()
                .verifyJobPosition();
        contactsPage.clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterDougAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnRemoveText().clickOnRemoveButton();

    }


    //58782 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void acceptShiftOfferwithoutComments(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().acceptShift().clickOnSendButton().verifyYouDidText();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().verifyRequestedText();
    }


    //58746 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void offerShiftLogInAndOut(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        schedulePage.checkOfferedTextInBlueColor();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword());
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton();
        schedulePage.checkOfferedTextInBlueColor().clickOnFiveAmToSixAm().clickOnRemoveText().clickOnRemoveButton();

    }

    //58730 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void viewScheduleWithOfferedAndAvailableShifts(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().checkOfferedTextInBlueColor().verifyAvailabeBanner().clickOnFiveAmToSixAm()
                .clickOnRemoveText().clickOnRemoveButton();

    }


    //58731 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void viewScheduleWhenShiftOfferedByOthers(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().verifyAvailabeBanner();
    }


    //59199- incomplete
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void shiftOfferCreated(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();


        //should get notification in mgr mobile and click on that notification
    }


    //58921 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void rosterOfferedShift(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnFridayRoster().clickOnEightAmToNinePm().clickOnOfferButton()
                .enterAComment().clickOnSendButton();
        contactsPage.clickOnBackButton();
        schedulePage.verifyShiftOfferPendingText();

    }


    //58922-incomplete
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void colleagueRescindsShift(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnFridayRoster().clickOnEightAmToNinePm().clickOnOfferButton()
                .enterAComment().clickOnSendButton();
        contactsPage.clickOnBackButton();
        schedulePage.verifyShiftOfferPendingText();
        contactsPage.clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnFridayRoster().clickOnEightAmToNinePm().acceptShift().enterAComment
                ().clickOnSendButton().verifyYouDidText();
        contactsPage.clickOnBackButton();
        contactsPage.clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnFridayRoster().clickOnEightAmToNinePm().clickOnRemoveText()
                .clickOnRemoveButton();
        contactsPage.clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnFridayRoster().checkOfferedNotExist();

        //Notification should be seen
    }


    //65368 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void switchingBetweenNoShiftOfferToShiftOffer(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton().clickOnWednesdayRoster().clickOnThursdayRoster().clickOnFridayRoster()
                .clickOnSaturdayRoster();

    }

    //59132 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T8")
    public void increaseInShiftOfferVolunteers(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        SchedulePage schedulePage = new SchedulePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().clickOnOfferButton().enterAComment()
                .clickOnSendButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton();
        managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        schedulePage.verifyShiftOfferWithNoVolunteers();
        homepage.clickOnNavigateUpButton();
        mbuLearnPage.swipeBottomToTop();
        homepage.clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMarryAsUNANdPW();
        homepage.clickOnNavigateUpButton();
        loginPage.enterMarryAsUNANdPW().clickOnNavigateUpButton();
        schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().acceptShift().clickOnSendButton().verifyYouDidText();
        contactsPage.clickOnBackButton().clickOnBackButton();
        homepage.clickOnNavigateUpButton().clickOnSignOutButton().clickOnYesButton();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton();
        managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        schedulePage.verifyOneShiftOfferPendingText();
    }
}