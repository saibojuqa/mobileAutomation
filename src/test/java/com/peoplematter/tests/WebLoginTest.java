package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.core.Application;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.peoplematter.web.pojos.UserDetails;
import com.peoplematter.web.tests.SubmitApplication;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;


/**
 * Created by sai.boju on 2/14/17.
 */
public class WebLoginTest extends BaseTest {


    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();


    //58901 -- completed
    @Test
    public void loginAsMBU() throws InterruptedException, MalformedURLException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.selectWorkSpaceDropDownAndEnterWhatsHappening();
        application.initAndroidDriver();
        loginPage.enterMBUAsUNANdPW();
        Homepage homepage = new Homepage();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        MessagePage messagePage = new MessagePage();
        ContactsPage contactsPage = new ContactsPage();
        messagePage.clickOnMessageIcon();
        contactsPage.clickOnLocation().clickOnLocationName();
        Thread.sleep(2000);
        webLoginPage.verifyMessage();

    }

    //Create Requisition with no questions answered and pending status - incomplete
    @Test
    public void createRequisitionWithNoQuestionsAnsweredAndPendingStatus() throws InterruptedException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(3000);
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        //

    }

    //Create VideoSaiActionItem
    @Test
    public void createVideoAsanActionItem() throws InterruptedException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        webLoginPage.clickOnGoToMyActionItems();
        webLoginPage.enterTitleofActionItem("VideoSai");
        webLoginPage.enterDescriptionofActionItem();
        webLoginPage.dropDownforReceiverAction();
        webLoginPage.dueDateExpirationDate();
        webLoginPage.clickOnSpecificRoleDropDown().clickOnSendButton();

    }

    //Create Pdf ActionItem
    @Test
    public void createPdfAsanActionItem() throws InterruptedException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        webLoginPage.clickOnGoToMyActionItems();
        webLoginPage.enterTitleofActionItem("PDF new");
        webLoginPage.enterDescriptionofActionItem();
        Thread.sleep(2000);
        webLoginPage.dropDownforReceiverAction();
        webLoginPage.dueDateExpirationDate();
        webLoginPage.clickOnSpecificRoleDropDown();
        webLoginPage.clickOnSendButton();
    }

    //Create Action Item To Acknowledge A Message
    @Test
    public void createMessageAsanActionItem() throws InterruptedException {
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        webLoginPage.clickOnGoToMyActionItems();
        webLoginPage.enterTitleofActionItem("MessageSai");
        webLoginPage.enterDescriptionofActionItem();
        Thread.sleep(2000);
        webLoginPage.enterMessageActionitem("Hi, this is test");
        webLoginPage.dueDateExpirationDate();
        webLoginPage.clickOnSpecificRoleDropDown();
        webLoginPage.clickOnSendButton();
    }

    //58900 - completed
    @Test
    public void submitRequestOnBlackoutDate() throws InterruptedException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(4000);
        webLoginPage.clickOnSettingsDropdown();
        Thread.sleep(3000);
        webLoginPage.scrollUntilBlackOutDate();
        // webLoginPage.clickOnBlackoutDatesButton();
        Thread.sleep(3000);
        webLoginPage.clickOnAddNewButton().addBlackOutDateInformation();
    }

    //58815
    @Test
    public void publishPushNotification() throws InterruptedException, MalformedURLException {
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
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

    //124618 - incomplete
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    public void applicationSubmitted(Map<String, String> testData) throws IOException, InterruptedException, AWTException {
        UserDetails userDetails = mapper.readValue(testData.get("userDetails"), UserDetails.class);
        userDetails.setFirstName(userDetails.getFirstName());
        userDetails.setLastName(userDetails.getLastName() + RandomStringUtils.randomAlphabetic(10));
        SubmitApplication submitApplication = new SubmitApplication();
        submitApplication.submitUserApplication(userDetails);
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
        //verify abc xyz


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
        HireTest hireTest = new HireTest();
        ContactsPage contactsPage = new ContactsPage();
        RecruitingPage recruitingPage = new RecruitingPage();
        ManagePage managePage = new ManagePage();
        Homepage homepage = new Homepage();
        Application application = new Application();
        LoginPage loginPage = new LoginPage();
        application.initFireFoxDriver();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        Thread.sleep(3000);
        webLoginPage.scrollUntilCreateANewRequisition();
        Thread.sleep(2000);
        webLoginPage.createANewRequisitionWithOpenStatus();
        application.initAndroidDriver();
        loginPage.enterMBUAsUNANdPW();
        homepage.clickOnNavigateUpButton().expandManageOptions();
        managePage.clickOnHomeButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        homepage.clickOnNavigateUpButton();
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
}
