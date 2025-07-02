package com.chiragrathava.tests.pageFactory;

import com.chiragrathava.base.CommonToAll_Test;
import com.chiragrathava.pages.pageFactory.appvwo.LoginPage_PF;
import com.chiragrathava.utils.Properties_Reader;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.chiragrathava.driver.DriverManager.getDriver;

public class TestVWOLogin_PF extends CommonToAll_Test {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_PF.class);


    @Test
    public void testLoginNegativeVWO_PF() {
        logger.info("Starting the Testcases page Factory");
        getDriver().get(Properties_Reader.readKey("url"));

        LoginPage_PF loginPagePf = new LoginPage_PF(getDriver());
        String error_msg = loginPagePf.loginToVWO_InvalidCreds();
        logger.info("Error msg I got " + error_msg);

        logger.info("Finished the Testcases page Factory");
        Assert.assertEquals(error_msg, Properties_Reader.readKey("error_message"));
    }


}
