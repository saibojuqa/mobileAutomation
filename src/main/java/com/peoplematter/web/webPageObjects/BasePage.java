package com.peoplematter.web.webPageObjects;

import com.peoplematter.Interfaces.Constants;
import com.peoplematter.core.Application;
import com.peoplematter.selenium.FluentDriver;

/**
 * Created by sai.boju on 12/22/16.
 */
public class BasePage extends Application implements Constants {

    private FluentDriver fluentDriver;

    public FluentDriver getWd() {
        if (fluentDriver == null) {
            initWebdriver();
        }
        return fluentDriver;
    }


    public void initWebdriver() {
        fluentDriver = new FluentDriver(Application.getWebdriver());
    }

    public void quitWebdriver() {
        Application.getWebdriver().quit();
    }
}
