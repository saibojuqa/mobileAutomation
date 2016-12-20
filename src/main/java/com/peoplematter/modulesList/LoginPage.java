package com.peoplematter.modulesList;

import com.peoplematter.modulesList.modules.pages.Homepage;
import com.peoplematter.pageObjects.BasePage;

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

    public String getErrorMessage() {
        return getfd().element(id(ERROR_MESSAGE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().getText();

    }

    public String getDilogTitle() {
        return getfd().element(id(ERROR_TITLE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().getText();

    }
}
