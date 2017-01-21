package com.peoplematter.tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sai.boju on 1/17/17.
 */
public class SampleMobileWebTest {

    private AndroidDriver driver;
    public static String baseurl;

    @Test
    public void setup() throws MalformedURLException, InterruptedException {
        System.out.println("Hello");
        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability("browsername","chrome");
        capabilities.setCapability("device","android");
        capabilities.setCapability("deviceName","1115fb45a8c01303");
        capabilities.setCapability("platformversion","6.0.1");
        capabilities.setCapability("platformname","Android");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);
        baseurl = "https://www.facebook.com";
        driver.get(baseurl);
    }
}
