package com.peoplematter.web.webPageObjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

/**
 * Created by sai.boju on 12/26/16.
 */
public class BusinessUnitsPage extends BasePage {

    private static final String CITY_INPUT = "City1";
    private static final String STATE_INPUT = "State1";
    private static final String ZIPCODE_INPUT = "ZipCode1";
    private static final String BUSINESS_UNITS_PAGE_CONTAINER = "SelectALocationPage";
    private static final String SEARCH_BUTTON = "SelectLocations-SearchButton";
    private static final String LOCATION_BUTTON = "//p[contains(text(),'%s')]/preceding-sibling::h3";
    private static final String NEXT_BUTTON = "moveNextSection";

    public BusinessUnitsPage() {
        getWd().element(By.id(BUSINESS_UNITS_PAGE_CONTAINER)).waitUntil(MAX_TIME).ifElementIsNotDisplayed();
    }

    public BusinessUnitsPage enterLocationDetails(String city, String state, String zipcode) {
        if (StringUtils.isNoneBlank(city)) {
            getWd().element(By.id(CITY_INPUT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(city);
        }
        if (StringUtils.isNoneBlank(state)) {
            getWd().element(By.id(STATE_INPUT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys(state);
        }
        if (StringUtils.isNoneBlank(zipcode)) {
            getWd().element(By.id(ZIPCODE_INPUT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().clear().sendKeys
                    (zipcode);
        }
        getWd().element(By.id(SEARCH_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return this;
    }

    public SelectJobsPage selectLocationAndClickNext(String zipCode) {
        getWd().element(By.xpath(String.format(LOCATION_BUTTON, zipCode))).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .click();
        getWd().element(By.id(NEXT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return new SelectJobsPage();
    }

}
