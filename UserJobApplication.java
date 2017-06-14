package com.peoplematter.tests;

import com.peoplematter.core.Application;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by sai.boju on 6/4/17.
 */
public class UserJobApplication {

  public WebDriver driver=null;
    public WebDriverWait wait = null;

    @BeforeTest
    public void init() {
        System.setProperty("webdriver.gecko.driver","/Users/sai.boju/Downloads/geckodriver");
        driver=new FirefoxDriver();
        driver.get("https://qa-prod.peoplematter.com/mbt/hire/");
        wait = new WebDriverWait(driver,15);
    }

    @Test
    public void test(){
        driver.findElement(By.id("GetStartedPage-GetStartedButton")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ZipCode1")));
        driver.findElement(By.id("ZipCode1")).sendKeys("30038");
        driver.findElement(By.id("SelectLocations-SearchButton")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h3[@title='Alpharetta Location 3']")));
        driver.findElement(By.xpath("//h3[@title='Alpharetta Location 3']")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Cook']")));
        driver.findElement(By.xpath("//label[text()='Cook']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("moveNextSection")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("person_FirstName")));
        driver.findElement(By.id("person_FirstName")).sendKeys("abc"+ RandomStringUtils.randomAlphabetic(10));
        driver.findElement(By.id("person_LastName")).sendKeys("xyz"+ RandomStringUtils.randomAlphabetic(10));
        driver.findElement(By.id("person_PIN")).sendKeys("2222");
        driver.findElement(By.id("person_VerifyPIN")).sendKeys("2222");
        select(driver,By.id("person_MonthOfBirth"),"6 - June");
        select(driver,By.id("person_DayOfBirth"),"3");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='selectedUSACountry']")));
        driver.findElement(By.xpath("//label[@for='selectedUSACountry']")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='agreedToESignatureDisclosuresAndConsent']")));
        driver.findElement(By.xpath("//label[@for='agreedToESignatureDisclosuresAndConsent']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='agreedToPeopleMatterTermsAndConditions']")));
         driver.findElement(By.xpath("//label[@for='agreedToPeopleMatterTermsAndConditions']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("moveNextSection")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("ethnicity-button")));
        select(driver,By.id("ethnicity-button"),"5");
        select(driver,By.id("gender-button"),"1");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("lbl-acceptedTermsAndConditions_b8168eb8-745a-4165-9bb5-a624015f5c1d")));
        driver.findElement(By.id("lbl-acceptedTermsAndConditions_b8168eb8-745a-4165-9bb5-a624015f5c1d")).click();
         driver.findElement(By.id("lbl-acceptedTermsAndConditionsWithSignature_f92bc9d4-cb1b-4167-b07d-a624015f5c1d")).click();
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("moveNextSection")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(@for,'hoursPerWeek')]/following-sibling::div/input")));
        driver.findElement(By.xpath("//label[contains(@for,'hoursPerWeek')]/following-sibling::div/input")).sendKeys
                 ("40");
          driver.findElement(By.xpath("//label[contains(@for,'availableAllWeek') and contains(text(),'all week')]")).click();
          select(driver,By.id("availableDate-cmbMonth"),"2");
          select(driver,By.id("availableDate-cmbDay"),"3");
          select(driver,By.id("availableDate-cmbYear"),"2018");
        select(driver,By.id("noticeLength_769fac16-b9c1-49b2-8dd3-9f5600bd774b"),"Two Weeks");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[contains(text(),'Address 1')]/following-sibling::div/input")));

        driver.findElement(By.xpath("//label[contains(text(),'Address 1')]/following-sibling::div/input")).sendKeys
                 ("111/14");
        driver.findElement(By.xpath("//label[contains(text(),'City')]/following-sibling::div/input")).sendKeys
                ("Henrico");
         select(driver,By.id("applicantState_ca45dd11-f4c6-411b-b1d1-9f5600bd774b"),"VA");
         driver.findElement(By.xpath("//label[contains(text(),'ZIP Code')]/following-sibling::div/input")).sendKeys
                 ("23294");
          driver.findElement(By.xpath("//label[contains(text(),'Home Phone')]/following-sibling::div/input"))
                  .sendKeys("1234567890");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.id
                ("moveNextSection")));
        driver.findElement(By.id("moveNextSection")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Submit']")));
        driver.findElement(By.xpath("//input[@value='Submit']")).click();

    }

    public void select(WebDriver driver ,By locator,String text){

        Select sel=new Select(driver.findElement(locator));
        System.out.println(text);
        sel.selectByVisibleText(text);


    }

    @AfterTest
    public void cleanUp(){
       driver.quit();
    }









}
