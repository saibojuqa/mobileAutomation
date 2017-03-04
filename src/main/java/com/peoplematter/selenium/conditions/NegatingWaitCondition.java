package com.peoplematter.selenium.conditions;

import com.google.common.base.Predicate;
import com.peoplematter.selenium.enums.WaitType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created by sai.boju on 11/18/16.
 */
@Log4j
public class NegatingWaitCondition implements Predicate<SearchContext> {

    private final By by;
    private WaitType waitType;
    private SearchContext searchContext;
    private boolean isElementFound;

    public NegatingWaitCondition(WaitType waitType, By by) {
        this.waitType = waitType;
        this.by = by;
    }


    @Override
    public boolean apply(SearchContext webDriver) {
        log.debug(String.format("Waiting for element %s to disappear", by));
        WebElement element;
        try {
            Thread.sleep(1000);
            element = webDriver.findElement(by);
            isElementFound = true;
            switch (waitType) {
                case NotPresent: {
                    return element == null;
                }
                case NotDisplyed: {
                    return element == null || !element.isDisplayed();

                }
            }

        } catch (WebDriverException ex) {
            return true;

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
