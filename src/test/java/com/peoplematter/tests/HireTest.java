package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.LoginPage;
import com.peoplematter.modulesList.modules.pages.ManagePage;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import com.peoplematter.web.pojos.UserDetails;
import com.peoplematter.web.tests.SubmitApplication;
import com.peoplematter.web.webPageObjects.GetStartedPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by sai.boju on 12/20/16.
 */
public class HireTest extends BaseTest {

    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();

    // 136089-completed-put location in this
    //cannot see applicants button
    //write for download application
    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")

    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T4")
    public void testApplicantApplication(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        ManagePage managePage = loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton().expandManageOptions();
        boolean isVisible = managePage.clickOnApplicantsButton().clickOnApplication(testData.get("applicantName"))
                .clickOnViewJobApplicationLink().isApplicantPageVisible();
        Assert.assertTrue(isVisible, "Applicant page is not visible");
    }

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T5")
    //For Web user application//
    public void sampleWebTest(Map<String, String> testData) throws IOException, InterruptedException {
        /*initWebDriver();
        System.out.println("Doneeeeeeeeeeeeeeeeeeeeeeeeeee");
        quitWebDiver();*/

        UserDetails userDetails = mapper.readValue(testData.get("userDetails"), UserDetails.class);
        userDetails.setFirstName(userDetails.getFirstName()+ RandomStringUtils.randomAlphabetic(10));
        userDetails.setLastName(userDetails.getLastName()+ RandomStringUtils.randomAlphabetic(10));
        SubmitApplication submitApplication=new SubmitApplication();
        submitApplication.submitUserApplication(userDetails);



    }
}
