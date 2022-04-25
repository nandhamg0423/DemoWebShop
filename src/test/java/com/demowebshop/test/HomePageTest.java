package com.demowebshop.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends Base {
    HomePage home;
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 1,enabled = true,description = "TC_001_Verify Home Page Title")
    public void verifyHomePageTitle() throws IOException {
        extentTest.get().assignCategory("Smoke");
        home=new HomePage(driver);
        String actualTitle=home.getHomePageTitle();
        extentTest.get().log(Status.PASS, "Login page title recieved");
        String expectedTitle="Demo Web Shop";
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid HomePage Titles");
        extentTest.get().log(Status.PASS, "Expected title is mached with actual home page title");
    }
}
