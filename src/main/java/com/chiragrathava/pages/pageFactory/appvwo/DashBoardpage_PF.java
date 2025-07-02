package com.chiragrathava.pages.pageFactory.appvwo;

import com.chiragrathava.base.CommonToAll_Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.chiragrathava.utils.WaitHelpers.visibilityOfElement;

public class DashBoardpage_PF extends CommonToAll_Page {

    WebDriver driver;

    public DashBoardpage_PF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "[data-qa = 'lufexuloga']")
    private WebElement usernameOnDashboard;

    // Page Actions
    public String loggedInUserName() {
        visibilityOfElement(usernameOnDashboard);
        return getText(usernameOnDashboard);
    }

}
