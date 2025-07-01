package com.chiragrathava.pages.pageObjectModel.appvwo.normal_POM;

import com.chiragrathava.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Class
public class Login_Page {

    WebDriver driver;

    public Login_Page(WebDriver driver)
    { this.driver = driver; }

    // step 1 -> Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it, don't keep.
    // private By singBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']")


    // step 2 -> Page Actions

    public String loginToVWOLogin_InvalidCreds(String user, String pwd){

        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait
//       /*1 Thread sleep */ WaitHelpers.waitJVM(5000);
        /*2 Explicit wait */ WaitHelpers.checkVisibility(driver,error_message);

        String error_message_text = driver.findElement(error_message).getText();
        return error_message_text;

    }

    public void loginToVWOLogin_ValidCreds(String user, String pwd){

        driver.get("https://app.vwo.com");
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait
//       /*1 Thread sleep */ WaitHelpers.waitJVM(5000);
        /*2 Explicit wait */ WaitHelpers.checkVisibility(driver,By.cssSelector("[data-qa='lufexuloga']"));


    }

}
