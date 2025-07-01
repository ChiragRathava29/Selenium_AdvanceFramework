package com.chiragrathava.tests.porm.vwo;

import com.chiragrathava.driver.DriverManager;
import com.chiragrathava.pages.pageObjectModel.appvwo.Improved_POM.LoginPage;
import com.chiragrathava.utils.Properties_Reader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.chiragrathava.pages.pageObjectModel.appvwo.Improved_POM.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_03_PropertyReader_DriverManager_POM {

    @Description("TC#1 - Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        // Driver Manager Code - 1
        DriverManager.init();

        // Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(DriverManager.getDriver());
        String error_msg = loginPage.loginToVWO_InvalidCreds(Properties_Reader.readKey("invalid_username"), Properties_Reader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,Properties_Reader.readKey("error_message"));

        DriverManager.getDriver().quit();
    }

    @Owner("Chirag")
    @Description("TC#2 - Verify that valid creds dashbord page is loaded")
    @Test
    public void test_positive_vwo_login() {

        DriverManager.init();

        LoginPage loginPage_VWO = new LoginPage(DriverManager.getDriver());
        loginPage_VWO.loginToVWOLogin_ValidCreds(Properties_Reader.readKey("username"),Properties_Reader.readKey("password"));

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,Properties_Reader.readKey("expected_username"));

        DriverManager.getDriver().quit();
    }

}
