package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.core.Application;
import com.peoplematter.modulesList.LoginPage;
import com.peoplematter.modulesList.modules.pages.ActionItemsPage;
import com.peoplematter.modulesList.modules.pages.OptionsPage;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
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

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T3")

    //140557-incomplete
    public void testActionItemsVideo(Map<String, String> testData) throws IOException {
       Application.getAndroidDriver().get("http://qavalidation.com/demo/");
        System.out.println(Application.getAndroidDriver().getTitle());
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton().clickOnNavigateUpButton();

        ActionItemsPage actionItemsPage = new OptionsPage().clickOnActionItems();
        Assert.assertTrue(actionItemsPage.isDescriptionVisible(testData.get("description1")));
                        Assert.assertTrue(actionItemsPage.isDescriptionVisible(testData.get("description2")));
        Assert.assertTrue(actionItemsPage.isDescriptionVisible(testData.get("description3")));
    }

    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T3")

    //141442-complete
    public void testPdfErrorMessage(Map<String, String> testData) throws IOException, InterruptedException {
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        loginPage.enterUserNameAndPassword(manage.getUserName(),
                manage.getPassword()).clickOnNavigateUpButton().clickOnNavigateUpButton();

        ActionItemsPage actionItemsPage = new OptionsPage().clickOnActionItems();
        Assert.assertTrue(actionItemsPage.clickOnCompletedTab().clickOnPdfButtonAndGetMessage());
    }


}
