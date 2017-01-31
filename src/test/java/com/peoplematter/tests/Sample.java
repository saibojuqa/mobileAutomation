package com.peoplematter.tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.URL;

/**
 * Created by sai.boju on 1/29/17.
 */
public class Sample {

    @Test
    public void test1() throws InterruptedException, Exception {

        DesiredCapabilities capabilities = DesiredCapabilities.android();
        //capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
        //DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "Browser");
        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.VERSION, "5.1.1");
        capabilities.setCapability("appPackage", "com.google.android.browser");
        capabilities.setCapability("appActivity", "com.google.android.browser/.BrowserMainActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        WebDriver driver = new AndroidDriver(url, capabilities);

        driver.get("http://learn-automation.com/");

    }
}