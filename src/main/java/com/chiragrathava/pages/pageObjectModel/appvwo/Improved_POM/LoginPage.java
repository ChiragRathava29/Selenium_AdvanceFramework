package com.chiragrathava.pages.pageObjectModel.appvwo.Improved_POM;

import com.chiragrathava.base.CommonToAll_Page;
import com.chiragrathava.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.chiragrathava.driver.DriverManager.getDriver;

public class LoginPage extends CommonToAll_Page {

    // Page Class
    // Page Locator
    WebDriver driver;

    public LoginPage(WebDriver driver)
    { this.driver = driver; }

    // Step 1 -> Page Locators
    private By username = By.name("username");
    private By password = By.name("password");
    private By signButton = By.xpath("//button[normalize-space()='Login']");
    private By error_message = By.id("js-notification-box-msg");

    public String loginToVWO_InvalidCreds(String user, String pwd)
    {
        openVWO_Url();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(),error_message);
        return getText(error_message);

    }

    public void loginToVWOLogin_ValidCreds(String user, String pwd){

        openVWO_Url();
        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signButton);

        WaitHelpers.checkVisibility(driver,By.cssSelector("[data-qa='lufexuloga']"));


    }

}
