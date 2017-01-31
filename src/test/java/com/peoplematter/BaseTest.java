package com.peoplematter;

import com.peoplematter.Interfaces.Constants;
import com.peoplematter.core.Application;
import com.peoplematter.utils.dataProvider.DataProviderArguments;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;

/**
 * Created by sai.boju on 11/19/16.
 */
public class BaseTest extends Application implements Constants {

    Application application = new Application();

    @BeforeSuite
    public void setup() {
        try {

            initAndroidDriver();
            //initWebAndroidDriver();
       } catch (MalformedURLException e) {
           e.printStackTrace();
        }
    }

    //   @AfterSuite
    public void tearDown() {
        Application.getAndroidDriver().closeApp();
    }
}
