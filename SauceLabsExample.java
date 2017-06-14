package com.peoplematter.tests;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Created by sai.boju on 4/3/17.
 */
public class SauceLabsExample {
    @Test

    public void launch() throws MalformedURLException {

        final String USERNAME = "sai_boju";
        final String ACCESS_KEY = "5d25f186-20f2-45b9-ac80-31c8a57a8228";
        final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
        DesiredCapabilities caps = DesiredCapabilities.android();
        caps.setCapability("appiumVersion", "1.6.3");
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "Samsung Galaxy S4 GoogleAPI Emulator");
        caps.setCapability("platformVersion", "4.4");
        caps.setCapability("deviceOrientation", "portrait");
        caps.setCapability("browserName", "");
        caps.setCapability("app","sauce-storage:peopleMatter-debug-qa-prod.apk");
        WebDriver driver = new AndroidDriver(new URL(URL), caps);
        driver.findElement(By.id("com.peoplematter.android:id/edit_text_email")).sendKeys("hello");
        driver.quit();
    }
}
