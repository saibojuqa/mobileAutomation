package com.peoplematter.tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peoplematter.BaseTest;
import com.peoplematter.modulesList.LoginPage;
import com.peoplematter.modulesList.modules.pojos.Manage;
import com.peoplematter.modulesList.manage.pages.ManagePage;
import com.peoplematter.modulesList.manage.pojos.Manage;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

/**
 * Created by sai.boju on 12/9/16.
 */
@Log4j
public class LoginTest extends BaseTest {


    public static final String FILE_PATH = "/testData/Template.xls";
    ObjectMapper mapper = new ObjectMapper();



    @Test(dataProviderClass = com.peoplematter.utils.dataProvider.ExcelDataProvider.class, dataProvider = "excel")
    @DataProviderArguments(filePath = FILE_PATH, sheetName = "T2")
    //125623-
    public void testInvalidPasswordScenario(Map<String, String> testData) throws IOException {
        LoginPage loginPage = new LoginPage();
        Manage manage = mapper.readValue(testData.get("data"), Manage.class);
        String errorMessage = loginPage.enterUserNameandPassword(manage.getUserName(), manage.getPassword()).getErrorMessage();
        log.info(errorMessage);
        Assert.assertEquals(errorMessage, "Oops! Please check your username and password.");
        Assert.assertEquals(loginPage.getDilogTitle(), "Sign In");

    }
}
