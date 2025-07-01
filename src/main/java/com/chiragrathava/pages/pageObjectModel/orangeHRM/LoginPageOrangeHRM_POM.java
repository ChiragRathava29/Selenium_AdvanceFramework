package com.chiragrathava.pages.pageObjectModel.orangeHRM;

import com.chiragrathava.base.CommonToAll_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.chiragrathava.utils.WaitHelpers.waitJVM;

public class LoginPageOrangeHRM_POM extends CommonToAll_Page {

    WebDriver driver;
    public LoginPageOrangeHRM_POM(WebDriver driver)
    { this.driver = driver; }

    // page locators

    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");

    public void loginToHRCreds(String user, String pwd){
       openOrangeHRM_Url();

        waitJVM(5000);

        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(submit_btn);

        waitJVM(5000);

    }

}
