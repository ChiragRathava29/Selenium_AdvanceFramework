package com.chiragrathava.tests.porm.vwo.ddt;

import com.chiragrathava.base.CommonToAll_Test;
import com.chiragrathava.pages.pageObjectModel.appvwo.Improved_POM.LoginPage;
import com.chiragrathava.utils.Properties_Reader;
import com.chiragrathava.utilsTest.UtilExcel;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



import static com.chiragrathava.driver.DriverManager.driver;
import static com.chiragrathava.driver.DriverManager.getDriver;

public class test_DDT_TestNG_POI_REAL_VWOLOGIN  extends CommonToAll_Test {

    @Test(dataProvider = "getData")
    public void test_vwo_login(String email, String password) {
        System.out.println(email + " - " + password);

        getDriver().navigate().to(Properties_Reader.readKey("url"));
        Assert.assertEquals(getDriver().getTitle(),Properties_Reader.readKey("current_title"));
        Assert.assertEquals(getDriver().getCurrentUrl(),Properties_Reader.readKey("current_url"));

        LoginPage loginPage = new LoginPage(getDriver());
        String error_message = loginPage.loginToVWO_InvalidCreds(email, password);

        Assert.assertEquals(error_message, Properties_Reader.readKey("error_message"));

    }

    @DataProvider(parallel = true)
    public Object[][] getData() {
        // READ THE DATA FROM THE EXCEL FILE
        // GIVE THEM IN THE 2D ARRAY
        return UtilExcel.getTestDataFromExcel("sheet1");
    }

}

