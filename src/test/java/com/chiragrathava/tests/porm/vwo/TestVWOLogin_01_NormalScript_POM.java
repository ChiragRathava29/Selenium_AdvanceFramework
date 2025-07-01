package com.chiragrathava.tests.porm.vwo;

import com.chiragrathava.pages.pageObjectModel.appvwo.normal_POM.Dashboard_Page;
import com.chiragrathava.pages.pageObjectModel.appvwo.normal_POM.Login_Page;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestVWOLogin_01_NormalScript_POM {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login() throws Exception {

        // Driver Manager Code - 1
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--Start-maximized");
        WebDriver driver = new EdgeDriver(edgeOptions);

        // Page Class Code (POM Code) - 2
        Login_Page loginPage = new Login_Page(driver);
        String error_msg = loginPage.loginToVWOLogin_InvalidCreds("admin@gmail.com","1234");


        // Assertions - 3
        assertThat(error_msg).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error_msg,"Your email, password, IP address or location did not match");

        driver.quit();
    }

    @Owner("Chirag")
    @Description("Verify that valid creds dashbord page is loaded")
    @Test
    public void test_positive_vwo_login() {

        WebDriver driver = new EdgeDriver();
        Login_Page loginPage_VWO = new Login_Page(driver);
        loginPage_VWO.loginToVWOLogin_ValidCreds("contact+aug@thetestingacademy.com","TtxkgQ!s$rJBk85");

        Dashboard_Page dashboardPage = new Dashboard_Page(driver);
        String usernameLoggedIn = dashboardPage.loggedInUserName();

        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,"Aman");

        driver.quit();
    }
}
