package com.peoplematter.selenium.conditions;

import com.google.common.base.Function;
import com.peoplematter.selenium.enums.WaitType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created by sai.boju on 11/14/16.
 */
@Log4j
public class WaitCondition implements Function<SearchContext, WebElement> {


    private WaitType waitType;
    private final By by;
    private SearchContext searchContext;

    public WaitCondition(WaitType waitType, By by, SearchContext searchContext) {
        this.waitType = waitType;
        this.by = by;
        this.searchContext = searchContext;
    }

    public WebElement apply(SearchContext searchContext) {
        try {

            WebElement element = searchContext.findElement(by);

            switch (waitType) {
                case Displayed:
                    log.info(String.format("waiting for element %s to be displayed", by));
                    if (element.isDisplayed()) {
                        return element;
                    }
                    break;
                case Enabled:
                    log.info(String.format("waiting for element %s to be enabled", by));
                    if (element.isEnabled()) {
                        return element;
                    }
                    break;
                case Clickable:
                    log.info(String.format("waiting for element %s to be clickable", by));
                    if (element.isDisplayed() && element.isEnabled()) {
                        return element;
                    }
                    break;
                case Present:
                    log.info(String.format("waiting for element %s to be present", by));
                    return element;
            }
        } catch (WebDriverException ex) {
            log.error(String.format("Element %s is not found retrying to find it again...", by));
            return null;
        }
        return null;
    }


}
