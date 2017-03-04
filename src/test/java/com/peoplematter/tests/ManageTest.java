package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 12/7/16.
 */
@Log4j
public class ManageTest extends BaseTest {


    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T1")
    //114806-completed
    public void testIcons(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        managePage.clickOnMileStonesButton();
        AssertJUnit.assertTrue(managePage.isIconDisplayed("Birthday"));
        AssertJUnit.assertTrue(managePage.isIconDisplayed("First day"));
        AssertJUnit.assertTrue(managePage.isIconDisplayed("Anniversary"));
        AssertJUnit.assertTrue(managePage.isIconDisplayed("Milestones"));
    }

    /* 121567 - completed */
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T6")
    public void testFunctionalityAndSettings(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        HirePage hirePage = new HirePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        SchedulePage schedulePage = new SchedulePage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton().expandManageOptions();
        Homepage homepage = managePage.clickOnHomeButton();
        Assert.assertTrue(homepage.isDateVisible(), "Date is not visible");
        Assert.assertTrue(homepage.isUpcomingTextVisible(), "Upcoming text is not visible");
        homepage.clickOnApplicantsTab();
        Assert.assertTrue(homepage.isApplicantsInLast14DaysVisible(), "Last 14 days applicants are not visible");
        homepage.clickOnNavigateUpButton();
        managePage.clickOnContactsButton();
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin()
                .maryBaldwinIsDisplayed().clickOnBackButton();
        homepage.clickOnNavigateUpButton();
        hirePage.clickOnI9Button();
        contactsPage.clickOnLocation().clickOnLocationName();
        homepage.clickOnNavigateUpButton();
        mbuLearnPage.clickOnCourseButton().checkOverdueText();
        homepage.clickOnNavigateUpButton();
        mbuLearnPage.clickOnCompletedButton().checkWithinLast7DaysText();
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnRosterButton();
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnWorkingNowButton();
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnShiftOfferButon();
        homepage.clickOnNavigateUpButton();
        schedulePage.clickOnTimeoffButton();
    }

    //118691 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void ViewDocumentUpload(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton().expandManageOptions().clickOnContactsButton();
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin()
                .clickOnViewDocumentDetails()
                .verifyUploadedFile();
    }

    // 59011 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void checkTheBubbles(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        MBULearnPage mbuLearnPage = new MBULearnPage();
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton().expandManageOptions();
        Homepage homepage = managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        Assert.assertTrue(homepage.isDateVisible(), "Date is not visible");
        Assert.assertTrue(homepage.isUpcomingTextVisible(), "Upcoming text is not visible");
        managePage.verifyCoursesOverdueText().verifyCurrentlyWorkingText().verifyShiftOfferText().verifyTimeOfferText();
        homepage.clickOnNavigateUpButton();
        mbuLearnPage.swipeBottomToTop();
        homepage.clickOnSignOutButton().clickOnYesButton();
    }

    //114803 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void selectDifferentDates(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        managePage.clickOnMileStonesButton();
        Assert.assertTrue(managePage.isIconDisplayed("Milestones"));

    }

//75537 - completed

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void createFeedItem(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        MessagePage messagePage = new MessagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        TimeOffRequestPage timeOffRequestPage = new TimeOffRequestPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        messagePage.clickOnMessageIcon();
        contactsPage.clickOnLocation().clickOnLocationName();
        timeOffRequestPage.clickOnPlusButton();
        schedulePage.enterAComment().clickOnSendButton();
        managePage.verifyComment();
        homepage.ClickAndHold();
        managePage.verifyYourMAnagerPostedNewMessageText();
    }


    //114528 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void userWithDayMonthIdentifiers(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        SchedulePage schedulePage = new SchedulePage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        MessagePage messagePage = new MessagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions().clickOnContactsButton();
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin();
        managePage.verifyNoBirthdayOnRecord();
    }


    //114537 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void useWithAnniversaryAndHireDate(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        SchedulePage schedulePage = new SchedulePage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        MessagePage messagePage = new MessagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions().clickOnContactsButton();
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin();
        managePage.verifyHiredAtWithPlaceAndDate();

    }


}
