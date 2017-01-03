package com.peoplematter.web.tests;

import com.peoplematter.Interfaces.Constants;
import com.peoplematter.core.Application;


/**
 * Created by sai.boju on 12/26/16.
 */
public class WebBaseTest extends Application implements Constants {

    Application application = new Application();

    public void setup() {
        initWebDriver();
    }

}
