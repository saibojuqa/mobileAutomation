package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.*;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 12/20/16.
 */
public class HireTest extends WebBasePage {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    // 136089-completed
    @Test(priority=0,dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")

    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T4")
    public void ViewFullApplication(Map<String, String> testData) throws IOException, InterruptedException {
        logger = report.startTest("ViewFullApplication");
        LoginPage loginPage = new LoginPage();

        HirePage hirePage = new HirePage();

        Manage manage = mapper.readValue(testData.get("data"), Manage.class);

        ContactsPage contactsPage = new ContactsPage();

        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        logger.log(LogStatus.PASS, "Enter un,pw and login sucessfully and click Navigate Button and Expand Manage " +
                "Options" );
        hirePage.clickOnApplicatButton();
        logger.log(LogStatus.PASS, "Click On Application Button");
        contactsPage.clickOnLocation().clickOnLocationName();
        logger.log(LogStatus.PASS, "Click On Location and Location Name");
        hirePage.clickOnNEwApplication().clickOnViewJobApplicationLink();
        logger.log(LogStatus.PASS, "Click On New Application and Click Job Application Link");
        //download full job application

    }
    }
