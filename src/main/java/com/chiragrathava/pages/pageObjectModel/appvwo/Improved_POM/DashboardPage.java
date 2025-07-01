package com.chiragrathava.pages.pageObjectModel.appvwo.Improved_POM;

import com.chiragrathava.base.CommonToAll_Page;
import com.chiragrathava.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAll_Page {

    WebDriver driver;

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    private By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");

    // Page Actions
    public String loggedInUserName(){
        WaitHelpers.visibilityOfElement(userNameOnDashboard);
        return getText(userNameOnDashboard);
    }

}
