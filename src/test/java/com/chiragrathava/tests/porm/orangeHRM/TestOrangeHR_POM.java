package com.chiragrathava.tests.porm.orangeHRM;

import com.chiragrathava.base.CommonToAll_Test;
import com.chiragrathava.pages.pageFactory.orangeHRM.LoginPage_OrangeHRM_PF;
import com.chiragrathava.pages.pageObjectModel.orangeHRM.EmployeeListHomePage;
import com.chiragrathava.pages.pageObjectModel.orangeHRM.LoginPageOrangeHRM_POM;
import com.chiragrathava.utils.Properties_Reader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.chiragrathava.driver.DriverManager.driver;
import static com.chiragrathava.driver.DriverManager.getDriver;
import static com.chiragrathava.utils.WaitHelpers.waitJVM;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TestOrangeHR_POM extends CommonToAll_Test {

    @Owner("Chirag")
    @Description("Verify that the login to the OrangeHR")
    @Test
    public void test_LoginPositive(){
        waitJVM(5000);
        LoginPageOrangeHRM_POM loginHRpage = new LoginPageOrangeHRM_POM(getDriver());
        loginHRpage.loginToHRCreds(Properties_Reader.readKey("ohr_username"),Properties_Reader.readKey("ohr_password"));

        EmployeeListHomePage dashboardPagePom = new EmployeeListHomePage(getDriver());
        String loggedInUserName = dashboardPagePom.loggedInUserName();

        waitJVM(5000);
        assertThat(loggedInUserName).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedInUserName,Properties_Reader.readKey("ohr_expected_username"));
    }
}
