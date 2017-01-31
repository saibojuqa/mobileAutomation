package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.core.Application;
import com.peoplematter.modulesList.LoginPage;
import com.peoplematter.modulesList.modules.pages.ContactsPage;
import com.peoplematter.modulesList.modules.pages.Homepage;
import com.peoplematter.modulesList.modules.pages.ManagePage;
import com.peoplematter.modulesList.modules.pages.SchedulePage;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
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


    //58769 - complete
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

    }


//58782 - complete
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

//58746 - complete
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
    schedulePage.checkOfferedTextInBlueColor();

}

//58730 - completed -
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
    schedulePage.clickOnScheduleButton().clickOnFiveAmToSixAm().checkOfferedTextInBlueColor().verifyAvailabeBanner();
}

//58731 - completed (Check if shift offer is removed or not)

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

//59199-incomplete
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

    //should get notification in mgr mobile and click on that noification

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



}

