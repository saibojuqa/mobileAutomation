package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import com.peoplematter.pageObjects.BasePage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import static org.openqa.selenium.By.id;

/**
 * Created by sai.boju on 12/7/16.
 */
public class LoginPage extends BasePage {

    private static final String PACKAGE_NAME = "com.peoplematter.android:";
    private static final String USER_EMAIL = String.format("%sid/edit_text_email", PACKAGE_NAME);
    private static final String USER_PASSWORD = String.format("%sid/edit_text_password", PACKAGE_NAME);
    private static final String SIGN_BUTTON = String.format("%sid/button_sign_in", PACKAGE_NAME);
    private static final String ERROR_MESSAGE = String.format("%sid/dialog_alert_message", PACKAGE_NAME);
    private static final String ERROR_TITLE = String.format("%sid/dialog_alert_title", PACKAGE_NAME);


    public Homepage enterUserNameAndPassword(String userName, String password) {
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys(userName);
        getfd().input(id(USER_PASSWORD)).sendKeys(password);
        getfd().button(id(SIGN_BUTTON)).click();
        return new Homepage();
    }

    public LoginPage enterUserNameandPassword(String userName, String password) {
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys(userName);
        getfd().input(id(USER_PASSWORD)).sendKeys(password);
        getfd().button(id(SIGN_BUTTON)).click();
        return this;
    }

    public Homepage enterMarryAsUNANdPW() {
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("Mary@baldwin.com");
        getfd().input(id(USER_PASSWORD)).sendKeys("Password1");
        getfd().button(id(SIGN_BUTTON)).click();
        return new Homepage();
    }

    public Homepage enterMBUAsUNANdPW() {
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("mobile@businessunit.com");
        getfd().input(id(USER_PASSWORD)).sendKeys("Password1");
        getfd().button(id(SIGN_BUTTON)).click();
        return new Homepage();
    }

    public Homepage enterDougAsUNANdPW() {
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("doug@baldwin.com");
        getfd().input(id(USER_PASSWORD)).sendKeys("Password1");
        getfd().button(id(SIGN_BUTTON)).click();
        return new Homepage();
    }

    public Homepage enterUserAsUNAndPW(){
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("qa@mobile.com");
        getfd().input(id(USER_PASSWORD)).sendKeys("Password1");
        getfd().button(id(SIGN_BUTTON)).click();
        return new Homepage();
    }



    public String getErrorMessage() {
        return getfd().element(id(ERROR_MESSAGE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().getText();

    }

    public String getDilogTitle() {
        return getfd().element(id(ERROR_TITLE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().getText();

    }

/* Failur Capture Screen shots */
    public static String captursceenshots(WebDriver d, String screenshot) throws Exception
    {
        TakesScreenshot ts=(TakesScreenshot) Application.getAndroidDriver();
        File source=ts.getScreenshotAs(OutputType.FILE);
        String dest = "/Users/sai.boju/mobileAutomation/FailureScreenShots/"+screenshot+ "_"+System.currentTimeMillis() +".png";
        File destnation=new File(dest);
        FileUtils.copyFile(source,destnation);
        return dest;
    }

}
