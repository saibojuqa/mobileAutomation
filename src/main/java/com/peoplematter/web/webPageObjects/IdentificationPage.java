package com.peoplematter.web.webPageObjects;

import com.peoplematter.web.pojos.UserDetails;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/27/16.
 */
public class IdentificationPage extends BasePage {

    private static final String FIRST_NAME = "person_FirstName";
    private static final String LAST_NAME = "person_LastName";
    private static final String SSN_PIN = "person_PIN";
    private static final String VERIFY_SSN_PIN = "person_VerifyPIN";
    private static final String MONTH = "person_MonthOfBirth";
    private static final String DAY = "person_DayOfBirth";
    private static final String NEXT_BUTTON = "moveNextSection";

    public whatToExpectPage fillIdentificationDetails(UserDetails userDetails) {

        getWd().element(By.id(FIRST_NAME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getFirstName());
        getWd().element(By.id(LAST_NAME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getLastName());
        getWd().element(By.id(SSN_PIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getSsn());
        getWd().element(By.id(VERIFY_SSN_PIN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(userDetails
                .getVerifyPin());
        getWd().select(By.id(MONTH)).selectByText(userDetails.getMonth());
        getWd().select(By.id(DAY)).selectByText(userDetails.getDay());
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new whatToExpectPage();
    }


}
