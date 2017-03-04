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
 * Created by sai.boju on 2/1/17.
 */
public class RecruitingTest extends BaseTest {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    //123559 - completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T7")
    public void viewDocumentUpload(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        ContactsPage contactsPage = new ContactsPage();
        Homepage homepage = new Homepage();
        SchedulePage schedulePage = new SchedulePage();
        ActionItemsPage actionItemsPage = new ActionItemsPage();
        RecruitingPage recruitingPage = new RecruitingPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        OptionsPage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(), manage.getPassword()).
                clickOnNavigateUpButton();
        recruitingPage.clickOnRequisitionButton().clickOnPendingRequisition().clickOnStatusButton().verifyBackButton
                ().verifySaveButton().clickOnOpenButton().clickOnNoRadioButton().clickOnYesRadioButton();
        schedulePage.enterAComment();
        actionItemsPage.clickOnSaveButton();
        contactsPage.clickOnBackButton().clickOnBackButton();
        recruitingPage.clickOnRequisitionButton().clickOnPendingRequisition().clickOnStatusButton().verifyBackButton
                ().verifySaveButton().clickOnOpenButton().clickOnNoRadioButton().clickOnYesRadioButton();
        actionItemsPage.clickOnSaveButton();
        contactsPage.clickOnBackButton();
    }

    //122862
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
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