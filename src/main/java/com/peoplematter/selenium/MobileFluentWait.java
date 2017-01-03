package com.peoplematter.selenium;

import com.peoplematter.selenium.conditions.NegatingWaitCondition;
import com.peoplematter.selenium.conditions.WaitCondition;
import com.peoplematter.selenium.enums.WaitType;
import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by sai.boju on 11/14/16.
 */
@Log4j
public class MobileFluentWait<T> {

    private final int timeout;
    private final T fluentelement;
    private final By by;
    private boolean ignoreError;
    private SearchContext searchContext;
    private WaitType waitType;


    public MobileFluentWait(int timeout, T fluentElement, By by, SearchContext searchContext) {
        this.timeout = timeout;
        fluentelement = fluentElement;
        this.by = by;
        this.searchContext = searchContext;
    }

    public T ifElementIsNotDisplayed() {
        this.waitType = WaitType.Displayed;
        FluentWait wd = getWebDriverWait(searchContext, timeout);
        WaitCondition waitCondition = new WaitCondition(waitType, by, searchContext);
        try {
            wd.until(waitCondition);
        } catch (Exception ex) {
            if (!ignoreError) {
                throw ex;
            } else {
                log.info(String.format("Element %s did not appear in given time, so ignoring and continuing", by));
            }

        }
        return (T) fluentelement;
    }

    public T ifElementIsNotEnabled() {
        this.waitType = WaitType.Enabled;
        FluentWait wd = getWebDriverWait(searchContext, timeout);
        WaitCondition waitCondition = new WaitCondition(waitType, by, searchContext);
        try {
            wd.until(waitCondition);
        } catch (Exception ex) {
            if (!ignoreError) {
                throw ex;
            } else {
                log.info(String.format("Element %s did not get enabled in given time, so ignoring and continuing", by));
            }
        }
        return (T) fluentelement;
    }

    public T ifElementIsNotClickable() {
        this.waitType = WaitType.Clickable;
        FluentWait wd = getWebDriverWait(searchContext, timeout);
        WaitCondition waitCondition = new WaitCondition(waitType, by, searchContext);
        try {
            wd.until(waitCondition);
        } catch (WebDriverException ex) {
            if (!ignoreError) {
                throw ex;
            } else {
                log.info(String.format("Element %s did not become clickable in given time, so ignoring and continuing", by));
            }
        }
        return (T) fluentelement;
    }

    public void ifElementIsDisplayed() {
        this.waitType = WaitType.NotDisplyed;
        FluentWait wd = getWebDriverWait(searchContext, timeout);
        NegatingWaitCondition negatingWaitCondition = new NegatingWaitCondition(waitType, by);
        wd.until(negatingWaitCondition);
    }

    public T ifElementIsNotPresent() {
        this.waitType = WaitType.Present;
        return (T) fluentelement;
    }

    public MobileFluentWait<T> ignoringError() {
        this.ignoreError = true;
        return this;
    }

    public FluentWait getWebDriverWait(SearchContext webdriver, int timeout) {
        FluentWait<SearchContext> webDriverWait = new FluentWait<>(searchContext);
        webDriverWait.pollingEvery(2, TimeUnit.MILLISECONDS);
        webDriverWait.withTimeout(timeout, TimeUnit.SECONDS);
        return webDriverWait;
    }


    public int getTimeout() {
        return timeout;
    }

    WaitType getWaitType() {
        return waitType;
    }


}
