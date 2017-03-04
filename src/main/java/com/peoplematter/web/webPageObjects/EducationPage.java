package com.peoplematter.web.webPageObjects;

import com.peoplematter.core.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.awt.*;

/**
 * Created by sai.boju on 1/2/17.
 */
public class EducationPage extends BasePage {

    private static final String NEXT_BUTTON = "moveNextSection";


    public void scrollUntilNext() throws AWTException {

        /*JavascriptExecutor je = (JavascriptExecutor) Application.getWebdriver();
        WebElement element = Application.getWebdriver().findElement(By.xpath("./*//*[@id='select-358-button']/select"));
        je.executeScript("arguments[0].scrollIntoView(true);", element);*/

        Application.getWebdriver().findElement(By.id("moveNextSection")).sendKeys(Keys.ARROW_DOWN);

        System.out.println("Scrolled");

        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

    }


    public EducationPage clickNextButton() throws InterruptedException {

        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;


    }
}
