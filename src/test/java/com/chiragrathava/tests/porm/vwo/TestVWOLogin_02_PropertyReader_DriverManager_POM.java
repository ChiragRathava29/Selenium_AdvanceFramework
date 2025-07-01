package com.chiragrathava.tests.porm.vwo;

import com.chiragrathava.driver.DriverManager;
import com.chiragrathava.pages.pageObjectModel.appvwo.normal_POM.Dashboard_Page;
import com.chiragrathava.pages.pageObjectModel.appvwo.normal_POM.Login_Page;
import com.chiragrathava.utils.Properties_Reader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_02_PropertyReader_DriverManager_POM {

    @Description("TC#1 - Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        // Driver Manager Code - 1
        DriverManager.init();

        // Page Class Code (POM Code) - 2
        Login_Page loginPage = new Login_Page(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWOLogin_InvalidCreds(Properties_Reader.readKey("invalid_username"), Properties_Reader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,Properties_Reader.readKey("error_message"));

        DriverManager.getDriver().quit();
    }

    @Owner("Chirag")
    @Description("TC#2 - Verify that valid creds dashbord page is loaded")
    @Test
    public void test_positive_vwo_login() {

        Login_Page loginPage_VWO = new Login_Page(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLogin_ValidCreds(Properties_Reader.readKey("username"),Properties_Reader.readKey("password"));

        Dashboard_Page dashboardPage = new Dashboard_Page(DriverManager.getDriver());
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,Properties_Reader.readKey("expected_username"));

        DriverManager.getDriver().quit();
    }

}
