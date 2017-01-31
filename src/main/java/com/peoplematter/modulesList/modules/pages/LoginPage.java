package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.pageObjects.BasePage;

import static org.openqa.selenium.By.id;

/**
 * Created by sai.boju on 11/29/16.
 */
public class LoginPage extends BasePage {

    public static final String PACKAGE_NAME = "com.peoplematter.android:";
    private static final String USER_EMAIL = String.format("%sid/edit_text_email", PACKAGE_NAME);
    private static final String USER_PASSWORD = String.format("%sid/edit_text_password", PACKAGE_NAME);
    private static final String SIGN_BUTTON = String.format("%sid/button_sign_in", PACKAGE_NAME);


    public Homepage enterUserNameAndPassword(String userName, String password) {
        getfd().input(id(USER_EMAIL)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys(userName);
        getfd().input(id(USER_PASSWORD)).sendKeys(password);
        getfd().button(id(SIGN_BUTTON)).click();
        return new Homepage();
    }




    }


