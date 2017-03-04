package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.modules.pages.ContactsPage;
import com.peoplematter.modulesList.modules.pages.HirePage;
import com.peoplematter.modulesList.modules.pages.LoginPage;
import com.peoplematter.modulesList.modules.pages.ManagePage;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.peoplematter.web.pojos.UserDetails;
import com.peoplematter.web.tests.SubmitApplication;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 12/20/16.
 */
public class HireTest extends BaseTest {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    // 136089-completed
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")

    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T4")
    public void ViewFullApplication(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        HirePage hirePage = new HirePage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ContactsPage contactsPage = new ContactsPage();
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        hirePage.clickOnApplicatButton();
        contactsPage.clickOnLocation().clickOnLocationName();
        hirePage.clickOnNEwApplication().clickOnDownloadFullJobApplication().clickOnViewJobApplicationLink();

    }

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    //For Web user application//
    public void userSubmitApplicationOnline(Map<String, String> testData) throws IOException, InterruptedException, AWTException {
        /*initWebDriver();
        System.out.println("Doneeeeeeeeeeeeeeeeeeeeeeeeeee");
        quitWebDiver();*/

        UserDetails userDetails = mapper.readValue(testData.get("userDetails"), UserDetails.class);
        userDetails.setFirstName(userDetails.getFirstName() + RandomStringUtils.randomAlphabetic(10));
        userDetails.setLastName(userDetails.getLastName() + RandomStringUtils.randomAlphabetic(10));
        SubmitApplication submitApplication = new SubmitApplication();
        submitApplication.submitUserApplication(userDetails);
    }
}
