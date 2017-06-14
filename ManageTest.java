package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.relevantcodes.extentreports.LogStatus;
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

    @Test(priority=0,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T1")
    //114806-completed
    public void testIcons(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("testIcons");
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully");
        managePage.clickOnMileStonesButton();
        logger.log(LogStatus.PASS, "Click on MileStones Button");
        Assert.assertTrue(managePage.isIconDisplayed("Birthday"));
        logger.log(LogStatus.PASS, "Verify the validation Birthday Text is displayed");
        Assert.assertTrue(managePage.isIconDisplayed("First day"));
        logger.log(LogStatus.PASS, "Verify the validation First day Text is displayed");
        Assert.assertTrue(managePage.isIconDisplayed("Anniversary"));
        logger.log(LogStatus.PASS, "Verify the validation Anniversary Text is displayed");
        Assert.assertTrue(managePage.isIconDisplayed("Milestones"));
        logger.log(LogStatus.PASS, "Verify the validation Milestones Text is displayed");
    }


    /* 121567 - completed */
    @Test(priority=1,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T6")
    public void testFunctionalityAndSettings(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("testFunctionalityAndSettings");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        HirePage hirePage = new HirePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        SchedulePage schedulePage = new SchedulePage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully");
        Homepage homepage = managePage.clickOnHomeButton();
        logger.log(LogStatus.PASS, "Click on Home Button");
        Assert.assertTrue(homepage.isDateVisible(), "Date is not visible");
        logger.log(LogStatus.PASS, "Verify the validation Date is not visible Text is displayed");
        Assert.assertTrue(homepage.isUpcomingTextVisible(), "Upcoming text is not visible");
        logger.log(LogStatus.PASS, "Verify the validation Upcoming text is not visible Text is displayed");
        homepage.clickOnApplicantsTab();
        logger.log(LogStatus.PASS, "Click on Application Tab Button");
        Assert.assertTrue(homepage.isApplicantsInLast14DaysVisible(), "Last 14 days applicants are not visible");
        logger.log(LogStatus.PASS, "Verify the validation Last 14 days applicants are not visible Text is displayed");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        managePage.clickOnContactsButton();
        logger.log(LogStatus.PASS, "Click on Contacts Button");
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin()
                .maryBaldwinIsDisplayed().clickOnBackButton();
        logger.log(LogStatus.PASS, "Click on Location and LocationName after enter Contact Name and click MaryBaldwin" +
                " and click back button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        Thread.sleep(2000);
        hirePage.clickOnI9Button();
        logger.log(LogStatus.PASS, "Click on I9 Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "Click on Location and Location Name");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        mbuLearnPage.clickOnCourseButton().checkOverdueText();
        logger.log(LogStatus.PASS, "Click on Course Button and check Overdue Text");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        mbuLearnPage.clickOnCompletedButton().checkWithinLast7DaysText();
        logger.log(LogStatus.PASS, "Click on Completed Button and check with in Last 7 Days" );
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        schedulePage.clickOnRosterButton();
        logger.log(LogStatus.PASS, "Click on Roster Button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        schedulePage.clickOnWorkingNowButton();
        logger.log(LogStatus.PASS, "Click on Working Now Button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        schedulePage.clickOnShiftOfferButon();
        logger.log(LogStatus.PASS, "Click on ShiftOffer Button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        schedulePage.clickOnTimeoffButton();
        logger.log(LogStatus.PASS, "Click on TimeOff Button sucess");
    }

    //118691 - completed
    @Test(priority=2,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void ViewDocumentUpload(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("ViewDocumentUpload");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton().expandManageOptions().clickOnContactsButton();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully after click on Navigate, Expand Manage Option " +
                "and Contacts Button clicked sucessfully");
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin()
                .clickOnViewDocumentDetails()
                .verifyUploadedFile();
        logger.log(LogStatus.PASS, "Click on Location, Location Name afer Enter Contact Name and click on MaryBaldwin" +
                " and click on ViewDocumentDetails");
    }

    // 59011 - completed
    @Test(priority=3,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void checkTheBubbles(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("checkTheBubbles");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        MBULearnPage mbuLearnPage = new MBULearnPage();
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully after click on Navigate, Expand Manage Option Button clicked sucessfully");
        Homepage homepage = managePage.clickOnHomeButton();
        logger.log(LogStatus.PASS, "Click on Home Button");
                contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "Click on Location and Location Name");
        Assert.assertTrue(homepage.isDateVisible(), "Date is not visible");
        logger.log(LogStatus.PASS, "To verify the Validation error message is Date is not visible ");
        Assert.assertTrue(homepage.isUpcomingTextVisible(), "Upcoming text is not visible");
        logger.log(LogStatus.PASS, "To verify the Validation error message is Upcomming text is not visible ");
        managePage.verifyCoursesOverdueText().verifyCurrentlyWorkingText().verifyShiftOfferText().verifyTimeOfferText();
       logger.log(LogStatus.PASS, "To verify the Validation error message is Overdue ,Current Working Text,Verify " +
                "Shift" + " offer and Time Offer Text ");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button");
        Thread.sleep(3000);
        mbuLearnPage.swipeBottomToTop();
        logger.log(LogStatus.PASS, "Swipe to Bottom to Top");
        homepage.clickOnSignOutButton().clickOnYesButton();
        logger.log(LogStatus.PASS, "Click on Sign Out Button and yes button ");
    }

    //114803 - completed
    @Test(priority=4,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void selectDifferentDates(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("selectDifferentDates");
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully ");
        managePage.clickOnMileStonesButton();
        logger.log(LogStatus.PASS, "Click on MileStones Button");

        Assert.assertTrue(managePage.isIconDisplayed("Milestones"));
        logger.log(LogStatus.PASS, "To Verify the Validation Error Messages is MileStones Text");

    }

//75537 - completed

    @Test(priority=5,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void createFeedItem(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("createFeedItem");
        LoginPage loginPage = new LoginPage();
        SchedulePage schedulePage = new SchedulePage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        MessagePage messagePage = new MessagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        TimeOffRequestPage timeOffRequestPage = new TimeOffRequestPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully ");
        messagePage.clickOnMessageIcon();
        logger.log(LogStatus.PASS, "Click on MessageIcon Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "Click on Location and Location Name Button");
        timeOffRequestPage.clickOnPlusButton();
        logger.log(LogStatus.PASS, "Click on Plus Button");
        schedulePage.enterAComment().clickOnSendButton();
        logger.log(LogStatus.PASS, "Click on Send Button");
        managePage.verifyComment();
        logger.log(LogStatus.PASS, "To Verify the Validation Error Message is Comment Text");
    }


    //114528 - completed
    @Test(priority=6,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void userWithDayMonthIdentifiers(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("userWithDayMonthIdentifiers");
        LoginPage loginPage = new LoginPage();
        SchedulePage schedulePage = new SchedulePage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        MessagePage messagePage = new MessagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        loginPage.enterMBUAsUNANdPW();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully ");
        homepage.clickOnNavigateUpButton().expandManageOptions().clickOnContactsButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button and Expand Manage Button and Click Contact Button");
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin();
        logger.log(LogStatus.PASS, "Click on Location and Location Name and Enter Contact Name and Click MaryBaldwin");
        managePage.verifyNoBirthdayOnRecord();
        logger.log(LogStatus.PASS, "To Verify the Validation Error Message is Birth Day on Records Text");
    }


    //114537 - completed
    @Test(priority=7,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider ="excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void useWithAnniversaryAndHireDate(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("useWithAnniversaryAndHireDate");
        LoginPage loginPage = new LoginPage();
        SchedulePage schedulePage = new SchedulePage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        ContactsPage contactsPage = new ContactsPage();
        MessagePage messagePage = new MessagePage();
        MBULearnPage mbuLearnPage = new MBULearnPage();
        loginPage.enterMBUAsUNANdPW();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully ");
        homepage.clickOnNavigateUpButton().expandManageOptions().clickOnContactsButton();
        logger.log(LogStatus.PASS, "Click on Navigate Button and Expand Manage Button and Click Contact Button");
        contactsPage.clickOnLocation().clickOnLocationName().enterContactName().clickOnMaryBaldwin();
        logger.log(LogStatus.PASS, "Click on Location and Location Name and Enter Contact Name and Click MaryBaldwin");
        managePage.verifyHiredAtWithPlaceAndDate();
        logger.log(LogStatus.PASS, "To Verify the Validation Error Message is Hired With Place and Date Text");

    }

}
