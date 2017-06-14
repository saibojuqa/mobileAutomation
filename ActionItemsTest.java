package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.ActionItemsPage;
import com.peoplematter.modulesList.modules.pages.LoginPage;
import com.peoplematter.modulesList.modules.pages.OptionsPage;
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
 * Created by sai.boju on 12/13/16.
 */
@Log4j
public class ActionItemsTest extends BaseTest {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();



    //141442-completed
    @Test(priority=0,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T3")

    public void testPdfErrorMessage(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("testPdfErrorMessage");
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton().clickOnNavigateUpButton();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and click Navigate Button ");
        ActionItemsPage actionItemsPage = new OptionsPage().clickOnActionItems();
        logger.log(LogStatus.PASS, "Click on Action Items Button ");
        actionItemsPage.clickOnCompletedTab().clickOnPdfButtonAndGetMessage();
        logger.log(LogStatus.PASS, "Click on Completed  Tab and Pdf Button and GetMessage");
    }
}
