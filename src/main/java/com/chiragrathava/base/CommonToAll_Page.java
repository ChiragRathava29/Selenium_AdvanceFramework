package com.chiragrathava.base;

import com.chiragrathava.utils.Properties_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.chiragrathava.driver.DriverManager.getDriver;

public class CommonToAll_Page {

    public CommonToAll_Page() {}

    public void openVWO_Url()
    { getDriver().get(Properties_Reader.readKey("url")); }

    public void openOrangeHRM_Url()
    { getDriver().get(Properties_Reader.readKey("ohr_url")); }

    public void clickElement(WebElement by)
    { by.click(); }
    public void clickElement(By locator)
    { getDriver().findElement(locator).click(); }

    public void enterInput(By by, String key)
    { getDriver().findElement(by).sendKeys(key); }

    public void enterInput(WebElement by, String key)
    { by.sendKeys(key); }

    public String getText(By by)
    { return getDriver().findElement(by).getText(); }

    public String getText(WebElement by)
    { return by.getText(); }

}
