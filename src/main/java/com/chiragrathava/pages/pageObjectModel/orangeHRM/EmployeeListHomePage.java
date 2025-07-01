package com.chiragrathava.pages.pageObjectModel.orangeHRM;

import com.chiragrathava.base.CommonToAll_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.chiragrathava.utils.WaitHelpers.waitJVM;

public class EmployeeListHomePage extends CommonToAll_Page {

    WebDriver driver;

    public EmployeeListHomePage(WebDriver driver)
    { this.driver = driver; }

    // Page Locators
    By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");

    // Page Actions
    public String loggedInUserName(){
        waitJVM(5000);
        return getText(userNameOnDashboard);
    }

}
