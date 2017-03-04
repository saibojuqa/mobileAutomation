package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.Interfaces.Constants;
import com.peoplematter.core.Application;
import com.peoplematter.selenium.FluentDriver;

/**
 * Created by sai.boju on 2/20/17.
 */
public class WebBasePage extends Application implements Constants {

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
