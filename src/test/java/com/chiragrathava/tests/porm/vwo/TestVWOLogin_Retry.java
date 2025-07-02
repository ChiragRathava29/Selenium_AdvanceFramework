package com.chiragrathava.tests.porm.vwo;

import com.chiragrathava.base.CommonToAll_Test;
import com.chiragrathava.listeners.RetryAnalyzer;
import com.chiragrathava.listeners.ScreenshotListener;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.chiragrathava.driver.DriverManager.getDriver;

@Listeners(ScreenshotListener.class)
@Test(retryAnalyzer = RetryAnalyzer.class)
public class TestVWOLogin_Retry extends CommonToAll_Test {

    private static final Logger logger = LogManager.getLogger(TestVWOLogin_Retry.class);

    @Owner("Chirag")
    @Description("Verify that invalid creds give error message")
    @Test
    public void test_Fail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcase Page Object Model");
        Assert.assertTrue(false);
    }

    @Owner("Chirag")
    @Description("Verify that invalid creds give error message")
    @Test
    public void test_Pass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcase Page Object Model");
        Assert.assertTrue(true);
    }

}
