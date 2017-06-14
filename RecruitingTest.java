package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.core.Application;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 2/1/17.
 */
public class RecruitingTest extends WebBasePage {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    //123559
    @Test(priority=0,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void viewDocumentUpload(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("viewDocumentUpload");
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Homepage homepage = new Homepage();
        SchedulePage schedulePage = new SchedulePage();
        ActionItemsPage actionItemsPage = new ActionItemsPage();
        RecruitingPage recruitingPage = new RecruitingPage();
        Application application = new Application();
        WebLoginPage webLoginPage = new WebLoginPage();
        webLoginPage.enterMBUAsUser();
        Thread.sleep(10000);
        logger.log(LogStatus.PASS, "STEP_1: Enter un,pw and login sucessfully");
        webLoginPage.selectWorkSpaceDropDownAndclickOnAdministrator();
        Thread.sleep(3000);
        logger.log(LogStatus.PASS, "STEP_2: Select Value In Dropdown Administrator");
        webLoginPage.scrollUntilCreateANewRequisition();
        Thread.sleep(2000);
        logger.log(LogStatus.PASS, "STEP_3: Scrol to Until Create New Requisition");
        webLoginPage.createANewRequisitionWithPendingStatus();
        logger.log(LogStatus.PASS, "STEP_4: Create New Requistion With Pending Status");
        //Application.getWebdriver().quit();
        Application.initAndroidDriver();
        logger.log(LogStatus.PASS, "STEP_5: Lauch Device ");
        loginPage.enterMBUAsUNANdPW().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_6: Enter un,pw and login sucessfully and click Navigate Button");
        recruitingPage.clickOnRequisitionButton().clickOnPendingRequisition().clickOnStatusButton().verifyBackButton
                ().verifySaveButton().clickOnOpenButton();
        logger.log(LogStatus.PASS, "STEP_7: Click On Requisition Button and Click On Pending Requisition and Click On" +
                " Sataus Button and Verify Back Button and Save Button and Click On Open Button");
        schedulePage.enterAComment();
        logger.log(LogStatus.PASS, "STEP_8: Enter a Comment");
        actionItemsPage.clickOnSaveButton();
        logger.log(LogStatus.PASS, "STEP_9: Click On Save Button");
        contactsPage.clickOnBackButton().clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_10: Click On Back Button");
        recruitingPage.clickOnRequisitionButton().clickOnAllOpenButton().clickOnPendingRequisition()
                .clickOnStatusButton().verifyBackButton().verifySaveButton().clickOnOpenButton();
        logger.log(LogStatus.PASS, "STEP_11: Click On Requisition Button and Click On All Open Button Click On " +
                "Pending Requisition and Click On Sataus Button and Verify Back Button and Save Button and Click On " +
                "Open Button");
        actionItemsPage.clickOnSaveButton();
        logger.log(LogStatus.PASS, "STEP_12: Click On Save Button");
        contactsPage.clickOnBackButton();
        logger.log(LogStatus.PASS, "STEP_13: Click On Back Button");
        homepage.clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "STEP_14: Click On Navigate Button");
        recruitingPage.clickOnRequisitionButton().clickOnMyOpenButton()
                .clickOnAutomateMobileRequisitionandVerifyApplicant1().clickOnStatusButton().clickOnCancelledButton()
                .clickOnSaveButton();
        logger.log(LogStatus.PASS, "STEP_15: Click On Requisition Button and Click On My Open Button Click On " +
                "Automate Mobile Requisition Verify and Click On Sataus Button and Click On Status Button and Click " +
                "On Cancled Button and Click On Save Button");
    }

    //122862

    @Test(priority=1,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void searchByRequisition(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Homepage homepage = new Homepage();
        SchedulePage schedulePage = new SchedulePage();
        ActionItemsPage actionItemsPage = new ActionItemsPage();
        RecruitingPage recruitingPage = new RecruitingPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        OptionsPage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton();
        recruitingPage.clickOnRequisitionButton();
        // search bar is not enabled
    }
}
