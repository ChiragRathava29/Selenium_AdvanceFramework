package com.chiragrathava.pages.pageFactory.appvwo;

import com.chiragrathava.base.CommonToAll_Page;
import com.chiragrathava.utils.Properties_Reader;
import com.chiragrathava.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

import static com.chiragrathava.driver.DriverManager.getDriver;

public class LoginPage_PF extends CommonToAll_Page {

    WebDriver driver;

    public LoginPage_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

//    @FindBy(id = "login-username")
//    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

//    private List<WebElement> list_element;

    @FindBy(css = "#js-notification-box-msg")
    private WebElement error_message;

    // Multiple Locator Types | OR condition (any criteria can match)
    @FindAll(
            {
                    @FindBy(how = How.ID, using = "login-username"),
                    @FindBy(name = "username")
            }
    )
    private WebElement username;

//    // AND condition
//    @FindAll(
//            {
//                    @FindBy(how = How.NAME,using = "password"),
//                    @FindBy(how = How.ID,using = "login-password")
//            }
//    )
//    private WebElement password;

//    WebElement username = driver.findElement(By.name("login-username"));

    // Page Actions
    public String loginToVWO_InvalidCreds()
    {
        enterInput(username, Properties_Reader.readKey("invalid_username"));
        enterInput(password,Properties_Reader.readKey("invalid_password"));
        clickElement(signButton);
        WaitHelpers.checkVisibility(getDriver(), By.cssSelector("#js-notification-box-msg"));
        return getText(error_message);

    }

}
