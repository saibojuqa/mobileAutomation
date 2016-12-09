package com.peoplematter.utils.listeners;

import com.peoplematter.selenium.utils.Screenshot;
import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;

/**
 * Created by sai.boju on 11/24/16.
 */
@Log4j
public class AUTListener extends TestListenerAdapter {

    private static String baseDir = System.getProperty("basedir", ".");
    private static String screenshot_Dir = baseDir + "/result/screenshots/failures";


    @Override
    public void onStart(ITestContext testContext) {
        File screenshotDirectory = new File(screenshot_Dir);
        if (!(screenshotDirectory.exists())) {
            screenshotDirectory.mkdirs();
        }
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        Screenshot.takeScreenshot(screenshot_Dir + tr.getInstanceName() +"__"+ tr.getName());
        long elapsedTime = tr.getEndMillis() - tr.getStartMillis();
        log.info("elapsed time in seconds is " + (elapsedTime / 1000));
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        long elapsedTime = tr.getEndMillis() - tr.getStartMillis();
        log.info("elapsed time in seconds is " + (elapsedTime / 1000));
    }


    @Override
    public void onConfigurationFailure(ITestResult tr) {
        super.onConfigurationFailure(tr);
        Screenshot.takeScreenshot(screenshot_Dir + tr.getInstanceName() +"__"+ tr.getName());
        long elapsedTime = tr.getEndMillis() - tr.getStartMillis();
        log.info("elapsed time in seconds is " + (elapsedTime / 1000));
    }




}
