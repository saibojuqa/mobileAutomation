package com.peoplematter.pageObjects;

import com.peoplematter.Interfaces.Constants;
import com.peoplematter.core.Application;
import com.peoplematter.selenium.FluentDriver;
import io.appium.java_client.android.AndroidKeyCode;

/**
 * Created by sai.boju on 11/19/16.
 */
public class BasePage implements Constants {

    public static final String PACKAGE_NAME = "com.peoplematter.android:";

    private FluentDriver fluentDriver;

    public FluentDriver getfd() {
        if (fluentDriver == null) {
            initFluentDriver();
        }
        return fluentDriver;
    }


    public void initFluentDriver() {
        fluentDriver = new FluentDriver(Application.getAndroidDriver());
    }

    public void navigateBackInMobile(){
        Application.getAndroidDriver().pressKeyCode(AndroidKeyCode.BACK);
    }

/*    public FluentDriver getWd() {
        if (fluentDriver == null) {
            initWebDriver();
        }
        return fluentDriver;
    }


    public void initWebDriver() {
        fluentDriver = new FluentDriver(Application.getWebdriver());
    }*/
}
