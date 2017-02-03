package com.peoplematter.tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.peoplematter.core.Application;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class test {
	public static void main(String[] args) throws Exception {

		DesiredCapabilities capabilities = DesiredCapabilities.android();
	      
	       
	       
	       capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,BrowserType.CHROME);
	     
	        capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "1115fb45a8c01303");
	        capabilities.setCapability(MobileCapabilityType.VERSION, "6.0.1");
	        //capabilities.setCapability("app", "/Users/sai.boju/Downloads/AndroidBrowser-16.1.0.5.apk");
	       // capabilities.setCapability("appPackage", "com.google.android.browser");
	        //capabilities.setCapability("appActivity", "com.google.android.browser/.BrowserMainActivity");

	        WebDriver driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	        driver.get("http://learn-automation.com/");

	}

}
