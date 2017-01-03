package com.peoplematter.web.webPageObjects;

import com.peoplematter.web.pojos.UserDetails;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 1/3/17.
 */
public class TellUsAboutYourselfPage11 extends BasePage{

    private static final String FIRST_NAME = "//label[contains(text(),'First Name')]/following-sibling::div/input";
    private static final String LAST_NAME = "//label[contains(text(),'Last Name')]/following-sibling::div/input";
    private static final String ADDRESS1 = "//label[contains(text(),'Address 1')]/following-sibling::div/input ";
    private static final String CITY = "//label[contains(text(),'City')]/following-sibling::div/input";
    private static final String STATE = "//select[@type='enum']";
    private static final String STATE_SELECTION = "//select[@type='enum']/descendant::option[text()='%s']";
    private static final String ZIP_CODE = "//label[contains(text(),'ZIP Code')]/following-sibling::div/input ";
    private static final String CELLPHONE ="//label[contains(text(),'Address 1')]/following-sibling::div/input";
    private static final String TEXT_MESSAGE = "//label[@for='isApplicationStatusByTextEnabled']";
    private static final String NEXT_BUTTON = "moveNextSection";



   public TaxCreditEligibilityPage12 enterDetails(UserDetails userDetails){

        getWd().element(By.xpath(FIRST_NAME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getFirstName());
        getWd().element(By.xpath(LAST_NAME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getLastName());
        getWd().element(By.xpath(ADDRESS1)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getAddress1());
        getWd().element(By.xpath(CITY)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getCity());
        getWd().element(By.xpath(STATE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getState());
       getWd().element(By.xpath(STATE_SELECTION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
               .getState_selection());
        getWd().element(By.xpath(ZIP_CODE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getVerifyPin());
         getWd().element(By.xpath(CELLPHONE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                 .getCellphone());
        getWd().element(By.id(TEXT_MESSAGE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return new TaxCreditEligibilityPage12();


    }

}
