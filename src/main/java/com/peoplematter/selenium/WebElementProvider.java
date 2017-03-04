package com.peoplematter.selenium;

import com.peoplematter.selenium.conditions.WaitCondition;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementProvider {

    private SearchContext searchContext;

    public WebElementProvider(SearchContext searchContext) {
        this.searchContext = searchContext;

    }

    public static WebElementProvider get(SearchContext searchContext) {
        return new WebElementProvider(searchContext);
    }

    /**
     * @param fluentElement
     * @return
     */
    public WebElement getElement(FluentElement fluentElement) {
        MobileFluentWait fluentWait = fluentElement.getFluentWait();
        if (fluentWait != null) {
            WebDriverWait webDriverWait = new WebDriverWait(fluentElement.getWebDriver(), fluentWait.getTimeout());
            WaitCondition waitCondition = new WaitCondition(fluentWait.getWaitType(), fluentElement.getBy(),
                    searchContext);
            return webDriverWait.until(waitCondition);
        } else {
            return searchContext.findElement(fluentElement.getBy());
        }
    }

}
