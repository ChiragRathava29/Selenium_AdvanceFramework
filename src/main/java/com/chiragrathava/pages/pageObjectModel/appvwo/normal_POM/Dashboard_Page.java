package com.chiragrathava.pages.pageObjectModel.appvwo.normal_POM;

import com.chiragrathava.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard_Page {

    WebDriver driver;

    public Dashboard_Page(WebDriver driver)
    { this.driver = driver; }

    private By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");

    // Page Actions
    public String loggedInUserName(){
        WaitHelpers.checkVisibility(driver,userNameOnDashboard);
        return driver.findElement(userNameOnDashboard).getText();
    }

}
