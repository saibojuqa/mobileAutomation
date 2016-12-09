package com.peoplematter.pageObjects.pages;


import com.peoplematter.pageObjects.BasePage;

import static org.openqa.selenium.By.*;

public class LoginPage extends BasePage {

    public void enterUserNameAndPassword() {
        getfd().input(id("com.peoplematter.android:id/edit_text_email")).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .sendKeys("qa@mobile.com");
        getfd().input(id("com.peoplematter.android:id/edit_text_password")).sendKeys("Password1");
        getfd().button(id("com.peoplematter.android:id/button_sign_in")).click();
    }
}


