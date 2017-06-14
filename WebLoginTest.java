package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.core.Application;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;


/**
 * Created by sai.boju on 2/14/17.
 */
public class WebLoginTest extends WebBasePage {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    //58901 -- completed
    @Test
    public void loginAsMBU() throws InterruptedException, MalformedURLException {
        logger = report.startTest("loginAsMBU");
        Application application = new Application();
        LoginPage loginPage = new LoginPage();

        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully");
        webLoginPage.selectWorkSpaceDropDownAndEnterWhatsHappening();
        logger.log(LogStatus.PASS, "STEP_2: Select Text In Dropdown and Enter a Text");
        application.initAndroidDriver();
        logger.log(LogStatus.PASS, "STEP_3: Setup done Device open People Matter Application");
        loginPage.enterMBUAsUNANdPW();
        logger.log(LogStatus.PASS, "STEP_4: Enter un,pw and login sucessfully");
        Homepage homepage = new Homepage();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "STEP_5: Click On Navigate Button and Expand Manage Options");
        MessagePage messagePage = new MessagePage();
        ContactsPage contactsPage = new ContactsPage();
        messagePage.clickOnMessageIcon();
        logger.log(LogStatus.PASS, "STEP_6: Click On Message Icon");
        contactsPage.clickOnLocation().clickOnLocationName();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "STEP_7: Click On Location and Location Name");
        webLoginPage.verifyMessage();
        logger.log(LogStatus.PASS, "STEP_8: Verify the Validation Message");

    }

    //Create VideoSaiActionItem - completed
    //140557
    @Test
    public void createVideoAsanActionItem() throws InterruptedException, AWTException, MalformedURLException {

        logger = report.startTest("createVideoAsanActionItem");

        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(10000);
        logger.log(LogStatus.PASS, "SETP_1: Enter un,pw and login sucessfully");
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "SETP_2: Select the Text in Dropdown and click Administrator");
        webLoginPage.clickOnGoToMyActionItems();
        logger.log(LogStatus.PASS, "SETP_3: Click On My Action Items");
        webLoginPage.enterTitleofActionItem("Video Sai");
        logger.log(LogStatus.PASS, "SETP_4: Enter the Title of Action Item");
        webLoginPage.enterDescriptionofVideo();
        logger.log(LogStatus.PASS, "SETP_5: Enter Description of Video");
        webLoginPage.dropDownforVideoReceiverAction();
        logger.log(LogStatus.PASS, "SETP_6: Select the text in Dropdown of Video Reciver Action");
        webLoginPage.uploadVideo();
        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "SETP_7: Upload th Video");
        webLoginPage.dueDateExpirationDate();
        logger.log(LogStatus.PASS, "SETP_8: Dute Date Expire Date");
        webLoginPage.clickOnSpecificRoleDropDown().clickOnSendButton();
        logger.log(LogStatus.PASS, "SETP_9: Select the Tet in Dropdown and Click Specufic Role and Click On Send " +
                "Button");
        Application.getWebdriver().quit();
        logger.log(LogStatus.PASS, "SETP_10: Driver quit In WebApplication");
        Application.initAndroidDriver();
        logger.log(LogStatus.PASS, "SETP_11: Setup done and open the Device People Matter Application");
        homepage.clickOnNavigateUpButton().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "SETP_12: Enter un,pw and login sucessfully and click Navigate Button ");
        ActionItemsPage actionItemsPage = new OptionsPage().clickOnActionItems();
        logger.log(LogStatus.PASS, "SETP_13: Click on Action Items Button ");
        Thread.sleep(5000);
        actionItemsPage.verifyDateIsDisplayed().verifyDescription().clickOnVideoSaiButton().clickOnCheckBox()
                .clickOnSaveButton().clickOnCompletedTab().verifyVideoSaiText();
        logger.log(LogStatus.PASS, "SETP_14: Verify the validatation Error Message is Date and Description After " +
                "Click on VideoSai Button and Click on CheckBox and Clcik on Save Button and Click on Completed Tab And Verify" +
                " Video Sai Text");


    }

    //Create Pdf ActionItem - completed
    @Test
    public void createPdfAsanActionItem() throws InterruptedException, AWTException {
        logger = report.startTest("createPdfAsanActionItem");
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS, "SETP_1: Enter UN and PW Login Sucess");
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        logger.log(LogStatus.PASS, "SETP_2: Select the Text in Dropdown and Click On Administrator");
        webLoginPage.clickOnGoToMyActionItems();
        logger.log(LogStatus.PASS, "SETP_3: Click On Go To My Action Items");
        webLoginPage.enterTitleofActionItem("PDF new");
        logger.log(LogStatus.PASS, "SETP_4: Enter Title of Action Items");
        webLoginPage.enterDescriptionofPdf();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "SETP_5: Enter Description of PDF");
        webLoginPage.dropDownforPdfReceiverAction();
        logger.log(LogStatus.PASS, "SETP_6: Dropdown Pdf Reciver Action");
        webLoginPage.uploadFile();
        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "SETP_7: Upload a File");
        webLoginPage.dueDateExpirationDate();
        logger.log(LogStatus.PASS, "SETP_8: Due Date Expire Date");
        webLoginPage.clickOnSpecificRoleDropDown();
        logger.log(LogStatus.PASS, "SETP_9: Select the Text in Dropdown Specific Role");
        webLoginPage.clickOnSendButton();
        logger.log(LogStatus.PASS, "SETP_10: Click On Send Button");
    }

    //Create Action Item To Acknowledge A Message - completed
    //140554 - completed
    @Test
    public void createMessageAsanActionItem() throws InterruptedException, MalformedURLException {
        logger = report.startTest("createMessageAsanActionItem");
        WebLoginPage webLoginPage = new WebLoginPage();
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        //application.initFireFoxDriver();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(10000);
        logger.log(LogStatus.PASS, "SETP_1: Enter UN and PW Login Sucess");
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        logger.log(LogStatus.PASS, "SETP_2: Select the Text in Dropdown and Click On Administrator");
        webLoginPage.clickOnGoToMyActionItems();
        logger.log(LogStatus.PASS, "SETP_3: Click On Go To My Action Items");
        webLoginPage.enterTitleofActionItem("MessageSai");
        logger.log(LogStatus.PASS, "SETP_4: Enter Title of Action Items");
        webLoginPage.enterDescriptionofMessage();
        logger.log(LogStatus.PASS, "SETP_5: Enter Description of Message");
        webLoginPage.dropDownforMessageReceiverAction();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "SETP_6: Dropdown Message Reciver Action");
        webLoginPage.enterMessageActionitem("Hi, this is test");
        logger.log(LogStatus.PASS, "SETP_7: Enter Message Action Items");
        webLoginPage.dueDateExpirationDate();
        logger.log(LogStatus.PASS, "SETP_8: Due Date Expire Date");
        webLoginPage.clickOnSpecificRoleDropDown();
        logger.log(LogStatus.PASS, "SETP_9: Select the Text in Dropdown Specific Role");
        webLoginPage.clickOnSendButton();
        logger.log(LogStatus.PASS, "SETP_10: Click On Send Button");
        Application.initAndroidDriver();
        logger.log(LogStatus.PASS, "SETP_11: Setup done and open the Device People Matter Application");
        loginPage.enterUserAsUNAndPW();
        homepage.clickOnNavigateUpButton().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "SETP_12: Enter un,pw and login sucessfully and click Navigate Button ");
        ActionItemsPage actionItemsPage = new OptionsPage().clickOnActionItems();
        logger.log(LogStatus.PASS, "SETP_13: Click on Action Items Button ");
        actionItemsPage.verifyDateIsDisplayed().verifyDescription().clickOnMessageSaiButton().verifyDisplayedMesssage().clickOnCheckBox()
                .clickOnSaveButton().clickOnCompletedTab().verifyMessageSaiText();
        logger.log(LogStatus.PASS, "SETP_14: Verify the validatation Error Message is Date and Description After " +
                "Click on VideoSai Button and Click on CheckBox and Clcik on Save Button and Click on Completed Tab And Verify" +
                " Meaasge is Sai Text");


    }

    //58900 - completed
    @Test
    public void submitRequestOnBlackoutDate() throws InterruptedException {
        logger = report.startTest("submitRequestOnBlackoutDate");
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        logger.log(LogStatus.PASS, "SETP_1: Enter UN and PW Login Sucess");
        webLoginPage.clickOnSettingsDropdown();
        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "SETP_2: Click On Setting In Dropdown");
        webLoginPage.scrollUntilBlackOutDate();
        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "SETP_3: Scrole Util to Black Out Date");
        webLoginPage.clickOnAddNewButton().addBlackOutDateInformation();
        logger.log(LogStatus.PASS, "SETP_4: Click On Add New Button and Add Black Out Date Information");
    }


    //58815
    @Test
    public void publishPushNotification() throws InterruptedException, MalformedURLException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(3000);
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        Thread.sleep(3000);
        webLoginPage.clickOnScheduleButton().clickOnLocationALphretta3();
        Thread.sleep(3000);
        webLoginPage.offerAShift();
        webLoginPage.addNewShift();
        webLoginPage.clickOnPublishSchedule();
        application.initAndroidDriver();
        loginPage.enterDougAsUNANdPW();
        Homepage homepage = new Homepage();
        homepage.clickOnNavigateUpButton();
    }

}
    /*

    //124618 - incomplete
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    public void applicationSubmitted(Map<String, String> testData) throws IOException, InterruptedException, AWTException {

        ContactsPage contactsPage = new ContactsPage();
        Homepage homepage = new Homepage();
        ManagePage managePage = new ManagePage();
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        //abc should apply online
        Application.initAndroidDriver();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton();
        managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        homepage.clickOnApplicantsTab();

        //verify abc

    }

    //124193 - incomplete
    @Test
    public void applicantAppliesToRequisitonPosition() throws MalformedURLException {
        HireTest hireTest = new HireTest();
        ContactsPage contactsPage = new ContactsPage();
        RecruitingPage recruitingPage = new RecruitingPage();
        Homepage homepage = new Homepage();
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        // call web from abc name
        application.initAndroidDriver();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton();
        recruitingPage.clickOnRequisitionButton().clickOnAllOpenButton();
        contactsPage.clickOnLocationName();
        recruitingPage.clickOnApplicantsAndVerifyThem();
    }

    //124078 - incomplete
    @Test
    public void applicantApplyToPosition() throws MalformedURLException, InterruptedException {
        Application application = new Application();
        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        Thread.sleep(3000);
        webLoginPage.scrollUntilCreateANewRequisition();
        Thread.sleep(2000);
        webLoginPage.createANewRequisitionWithOpenStatus();
        Thread.sleep(2000);
        application.initAndroidDriver();
        ContactsPage contactsPage = new ContactsPage();
        RecruitingPage recruitingPage = new RecruitingPage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        LoginPage loginPage = new LoginPage();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        homepage.clickOnNavigateUpButton().expandRecruitingOptions();
        recruitingPage.clickOnRequisitionButton().clickOnAllOpenButton().clickOnAutomateMobileRequisitionandVerifyApplicant0();

        //Run web here to apply from hire test

        application.initAndroidDriver();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        homepage.clickOnNavigateUpButton();
        recruitingPage.clickOnRequisitionButton().clickOnMyOpenButton()
                .clickOnAutomateMobileRequisitionandVerifyApplicant1().clickOnStatusButton().clickOnCancelledButton()
                .clickOnSaveButton();
    }

    //116066

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    //For Web user application//
    public void userSubmitApplicationOnline(Map<String, String> testData) throws Exception {
        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.clickOnSettingsDropdown();
        Thread.sleep(3000);
        webLoginPage.scrollUntilManageCourses();
        Thread.sleep(3000);
        webLoginPage.addNewCourse();
        // Complete the course in web
        // Mobile busines unit will receive completed



    }

    // 115753
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    //For Web user application//
    public void employeCourseCompleted(Map<String, String> testData) throws Exception {
        // first see in mobile course not complete
        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.clickOnSettingsDropdown();
        Thread.sleep(3000);
        webLoginPage.scrollUntilManageCourses();
        Thread.sleep(3000);
        webLoginPage.addNewCourse();
        // Go to web complete it
        // check rom complete tocom[leted

    }

    //115320
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    //For Web user application//
    public void managerCourseCompleted(Map<String, String> testData) throws Exception {

        //application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.clickOnSettingsDropdown();
        Thread.sleep(3000);
        webLoginPage.scrollUntilManageCourses();
        Thread.sleep(3000);
        webLoginPage.addNewCourse();
        // Go to web complete it
        //check it as completed from above test cases in Alphretta 3
        //go back create another requisition, complete it and check in some other location
    }

}*/
