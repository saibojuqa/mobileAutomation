package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.Interfaces.Constants;
import com.peoplematter.core.Application;
import com.peoplematter.selenium.FluentDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

/**
 * Created by sai.boju on 2/20/17.
 */
public class WebBasePage extends Application implements Constants {


    Application application = new Application();
    public static ExtentReports report;
    public static ExtentTest logger;

    int  row = 0;
    static String mailPath="/Users/sai.boju/mobileAutomation/AutomationReports/Automation.html";
    static String sAttachmentName="Automation.html";
    static int sPass=0;
    static int sFail=0;

    @BeforeMethod
    public void setup() throws Exception{
        initWebDriver();
        report =new ExtentReports("/Users/sai.boju/mobileAutomation/AutomationReports/Automation.html",false);
    }


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
@AfterMethod
    public void quitWebdriver(ITestResult result) throws Exception {
    //logger = report.startTest(result.getTestClass()+"_" +result.getName());
    String status = "";
    if (ITestResult.FAILURE == result.getStatus()) {

        status = "Fail";
        logger.log(LogStatus.FAIL, "FAILED");
        logger.log(LogStatus.FAIL, "Failed_  "+result.getThrowable().fillInStackTrace());
        sFail++;
        LoginPage.captursceenshots(Application.getWebdriver(), result.getName());
    } else if (ITestResult.SUCCESS == result.getStatus()) {
        status = "Pass";
        logger.log(LogStatus.PASS, "Passed");
        sPass++;
    } else if (ITestResult.SKIP == result.getStatus()) {
        status = "Skipped";
        logger.log(LogStatus.SKIP, "Skip");
    }
    report.endTest(logger);
    report.flush();
    Application.getWebdriver().quit();

}

    public static void report() throws Exception
    {
        int sTotal=sPass+sFail;
        EmailReport.sendingMail(mailPath,sAttachmentName,sPass,sFail,sTotal);
    }
    }




