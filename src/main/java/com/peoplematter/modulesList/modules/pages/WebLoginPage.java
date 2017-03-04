package com.peoplematter.modulesList.modules.pages;

import com.peoplematter.core.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by sai.boju on 2/14/17.
 */
public class WebLoginPage extends WebBasePage {


    private static final String USER_NAME = "ctl00_ContentPlaceHolder_UsernameTextBox";
    private static final String PASSWORD = "ctl00_ContentPlaceHolder_PasswordTextBox";
    private static final String SIGN_IN_BUTTON = "ctl00_ContentPlaceHolder_SubmitButton";
    private static final String ENTER_HAPPENING = "feed-item-message";
    private static final String SHARE_MESSAGE = "share";
    private static final String GOTOMYACTIONITEMS = ".//*[@id='content']/div/div[3]/div/div[2]/div/a";
    private static final String CREATE_NEW_ACTION_ITEM = "addNew";
    private static final String TITLE_ACTIONITEM = "Title";
    private static final String DESCRIPTION_ACTIONITEM = "Description";
    private static final String ENTER_MESSAGE_ACTIONITEM = "Message";
    private static final String DUE_DATE_ACTIONITEM = "DueDate";
    private static final String EXPIRATION_DATE = "ExpirationDate";
    private static final String DROPDOWN_WATCHVIDEO = ".//*[@id='ContentTypeOption-button']/span[3]";
    private static final String DROPDOWN_SELECTION = ".//*[@id='ContentTypeOption-menu']/li[3]/a";
    private static final String VERIFY_MESSAGE = "com.peoplematter.android:id/message_english";
    private static final String DROPDOWN_SENDTO = ".//*[@id='RecipientOption-button']";
    private static final String DROPDOWN_SELECTION_SPECIFIC_ROLES = ".//*[@id='RecipientOption-menu']/li[2]/a";
    private static final String SELECT_ROLE_DROPDOWN = "dropdowntitle-0";
    private static final String EMPLOYEE_ROLE_SELECTION = ".//*[@id='Roles-list']/li[5]/label";
    private static final String BUSINESSUNITADMIN_ROLE_SELECTION = ".//*[@id='Roles-list']/li[7]/label";
    private static final String SEND_BUTTON = "sendAction";
    private static final String SETTINGS_DROPDOWN = "//*[@id='head']/div/div/div/ul[3]/li[1]/a";
    private static final String MOBILE_TESTING_DROPDOWN = ".//*[@id='head']/div/div/div/ul[3]/li[1]/ul/li[2]/a";
    private static final String BLACKOUT_DATES_BUTTON = "//*[@title='Blackout Dates']";
    private static final String ADDNEW_BUTTON = "addNew";
    private static final String NAME_BLACKOUT = "title";
    private static final String BLACKOUT_DATES_MESSAGE = "description";
    private static final String SAVE_BUTTON = "save";
    private static final String PUBLISH_SCHEDULE_BUTTON = "publish-schedule-button";
    private static final String SHIFT_IN_SCHEDULE = ".//*[@name='Shifts[6].StartTime']";
    private static final String SHIFT_OUT_SCHEDULE = ".//*[@name='Shifts[6].EndTime']";
    private static final String SAVE_SHIFT_SCHEDULE = "save-edit-person";
    private static final String SCHEDULE_BUTTON = ".//*[@id='schedule-tab']/a/span";
    private static final String LOCATION_ALPHRETTA3 = ".//*[@id='location-schedule-table']/tbody/tr[6]/td[1]/a";
    private static final String EDIT_BUTTON = ".//*[@class='btn btn-opaque edit']";
    private static final String REFRESH_ICON = ".//*[@class='icon-refresh']";


    public WebLoginPage clickOnEditButton() {
        getWd().element(By.xpath(EDIT_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public WebLoginPage clickOnScheduleButton() {
        getWd().element(By.xpath(SCHEDULE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public WebLoginPage clickOnLocationALphretta3() {
        getWd().element(By.xpath(LOCATION_ALPHRETTA3)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public void offerAShift() {
        List<WebElement> lis = Application.getWebdriver().findElements(By.xpath("//*[@class='person-name editmode-disable']"));
        System.out.println("The total size : " + lis.size());
        for (WebElement e : lis) {
            String val = e.getAttribute("innerHTML");
            if (val.contains("Doug Baldwin")) {
                e.click();
                break;
            }

        }
    }


    public WebLoginPage clickOnSettingsDropdown() {
        getWd().element(By.xpath(SETTINGS_DROPDOWN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(MOBILE_TESTING_DROPDOWN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public void scrollUntilBlackOutDate() {
        JavascriptExecutor je = (JavascriptExecutor) Application.getWebdriver();
        WebElement element = Application.getWebdriver().findElement(By.xpath(".//*[@id='content']/section[10]/div[3]/h3/a"));
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }


    public void scrollUntilCreateANewRequisition() {

        ((JavascriptExecutor) Application.getWebdriver())
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement element = Application.getWebdriver().findElement(By.xpath(".//*[@href='/MBT/Hire/Recruiting/Requisitions/Add']"));
        element.click();

    }

    public void clickOnLocationDropdown() throws InterruptedException {
        WebElement lis = Application.getWebdriver().findElement(By.xpath(".//*[@id='s2id_autogen1']/a"));
        lis.click();
        Thread.sleep(2000);
        Application.getWebdriver().findElement(By.xpath(".//*[@id='select2-drop']/ul/li[6]/div")).click();
    }

    public void clickOnSelectJobDropdown() throws InterruptedException {
        WebElement lis = Application.getWebdriver().findElement(By.xpath(".//*[@id='s2id_autogen3']/a"));
        lis.click();
        Thread.sleep(2000);
        Application.getWebdriver().findElement(By.xpath(".//*[@id='select2-drop']/ul/li[1]/div")).click();
    }

    public void clickOnRequisitionStatusDropdown() throws InterruptedException {
        WebElement lis = Application.getWebdriver().findElement(By.xpath(".//*[@id='s2id_requisition-select-status']/a"));
        lis.click();
        Thread.sleep(2000);
        Application.getWebdriver().findElement(By.xpath(".//*[@id='select2-drop']/ul/li[2]/div")).click();
    }

    public void selectCalender() {
        Application.getWebdriver().findElement(By.xpath("//*[@class='icon-calendar']")).click();

        List<WebElement> allDates = Application.getWebdriver().findElements(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
        for (WebElement ele : allDates) {
            String date = ele.getText();
            if (date.equalsIgnoreCase("1")) {
                ele.click();
                break;
            }
        }
    }


    public WebLoginPage createANewRequisitionWithOpenStatus() throws InterruptedException {
        Thread.sleep(2000);
        getWd().element(By.xpath(REFRESH_ICON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Thread.sleep(2000);
        clickOnLocationDropdown();
        Thread.sleep(2000);
        clickOnSelectJobDropdown();
        clickOnRequisitionStatusDropdown();
        Thread.sleep(2000);
        selectCalender();
        Application.getWebdriver().findElement(By.xpath(".//*[@id='requisition-when-open']/div[1]/label")).click();
        Application.getWebdriver().findElement(By.xpath(".//*[@id='requisition-when-closed']/div[2]/label")).click();
        Application.getWebdriver().findElement(By.id("requisition-submit")).click();
        return this;
    }

    public WebLoginPage addNewShift() {
        getWd().element(By.xpath(SHIFT_IN_SCHEDULE)).clear();
        getWd().element(By.xpath(SHIFT_IN_SCHEDULE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("6a");
        getWd().element(By.xpath(SHIFT_OUT_SCHEDULE)).clear();
        getWd().element(By.xpath(SHIFT_OUT_SCHEDULE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("10a");
        getWd().element(By.id(SAVE_SHIFT_SCHEDULE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();

        return this;
    }

    public WebLoginPage clickOnPublishSchedule() {
        getWd().element(By.id(PUBLISH_SCHEDULE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public WebLoginPage clickOnBlackoutDatesButton() {
        getWd().element(By.xpath(BLACKOUT_DATES_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public WebLoginPage addBlackOutDateInformation() {
        getWd().element(By.id(NAME_BLACKOUT)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("Special Day");
        Application.getWebdriver().findElement(By.id("startDate")).sendKeys("10/19/2018", Keys.ENTER);
        getWd().element(By.id(BLACKOUT_DATES_MESSAGE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys("It's a Black Out Date");
        getWd().element(By.id(SAVE_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }


    public WebLoginPage clickOnAddNewButton() {
        getWd().element(By.id(ADDNEW_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public WebLoginPage clickOnSendButton() {
        getWd().element(By.id(SEND_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public void scroll() {
        JavascriptExecutor je = (JavascriptExecutor) Application.getWebdriver();
        WebElement element = Application.getWebdriver().findElement(By.xpath(".//*[@id='RecipientOption-button']"));
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public WebLoginPage clickOnSpecificRoleDropDown() throws InterruptedException {
        scroll();
        Application.getWebdriver().findElement(By.xpath(".//*[@id='RecipientOption-button']")).click();
        getWd().element(By.xpath(DROPDOWN_SELECTION_SPECIFIC_ROLES)).waitUntil(MAX_TIME).ifElementIsNotDisplayed()
                .click();
        getWd().element(By.id(SELECT_ROLE_DROPDOWN)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        getWd().element(By.xpath(EMPLOYEE_ROLE_SELECTION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Thread.sleep(2000);
        getWd().element(By.xpath(BUSINESSUNITADMIN_ROLE_SELECTION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;

    }


    public void clickOnGoToMyActionItems() throws InterruptedException {
        getWd().element(By.xpath(GOTOMYACTIONITEMS)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Thread.sleep(4000);
        getWd().element(By.id(CREATE_NEW_ACTION_ITEM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
    }

    public void enterTitleofActionItem(String text) {
        getWd().element(By.id(TITLE_ACTIONITEM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys(text);
    }

    public void enterDescriptionofActionItem() {
        Application.getWebdriver().findElement(By.id("Description")).sendKeys("This is just a video");
    }

    public void enterMessageActionitem(String text) {
        getWd().element(By.id(ENTER_MESSAGE_ACTIONITEM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys(text);
    }

    public void dueDateExpirationDate() throws InterruptedException {
        getWd().element(By.id(DUE_DATE_ACTIONITEM)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys
                ("10/07/2019");
        Application.getWebdriver().findElement(By.id("ExpirationDate")).sendKeys("10/19/2019", Keys.ENTER);
        Thread.sleep(2000);
    }


    public void dropDownforReceiverAction() throws InterruptedException {
        WebElement element = Application.getWebdriver().findElement(By.xpath(".//*[@id='ContentTypeOption-button']"));
        element.click();
        Thread.sleep(2000);
        getWd().element(By.xpath(DROPDOWN_SELECTION)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
    }

    public WebLoginPage enterMBUAsUser() {
        getWd().element(By.id(USER_NAME)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys
                ("mobile@businessunit.com");

        getWd().element(By.id(PASSWORD)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys
                ("Password1");
        getWd().element(By.id(SIGN_IN_BUTTON)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        return this;
    }

    public void selectWorkSpaceDropDownAndEnterWhatsHappening() throws InterruptedException {
        WebElement list = Application.getWebdriver().findElement(By.id("workspace-btn"));
        list.click();
        Thread.sleep(2000);
        Application.getWebdriver().findElement(By.xpath(".//*[@id='workspace-dropdown']/li[2]/a[1]")).click();
        getWd().element(By.id(ENTER_HAPPENING)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().sendKeys
                ("Automation Test check");
        Thread.sleep(5000);
        getWd().element(By.id(SHARE_MESSAGE)).waitUntil(MAX_TIME).ifElementIsNotDisplayed().click();
        Thread.sleep(3000);
        Application.getWebdriver().quit();
    }

    public void selectWorkSpaceDropDownAndclickOnAdministrator() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(Application.getWebdriver(), 20);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("workspace-btn")));
        element.click();

        //  WebElement list = Application.getWebdriver().findElement(By.id("workspace-btn"));
        //list.click();
        Thread.sleep(2000);
        Application.getWebdriver().findElement(By.xpath(".//*[@id='workspace-dropdown']/li[2]/a[1]")).click();
    }

    public WebLoginPage verifyMessage() {
        Application.getAndroidDriver().findElement(By.id("com.peoplematter.android:id/message_english")).isDisplayed();
        return this;
    }

}






