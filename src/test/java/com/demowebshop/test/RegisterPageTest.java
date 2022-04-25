package com.demowebshop.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.demowebshop.automationcore.Base;
import com.demowebshop.listeners.TestListener;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.pages.RegisterPage;
import com.demowebshop.utilities.ExcelUtility;
import com.demowebshop.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterPageTest extends Base {
    HomePage home;
    MyAccountPage account;
    ExcelUtility excel;
    RegisterPage register;
    RandomDataUtility random1=new RandomDataUtility();
    String randomMail=random1.random();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 4,enabled = true,description = "TC_002_Verify Valid User Login")
    public void verifyRegisterPage() throws IOException {
        extentTest.get().assignCategory("Sanity");
        home=new HomePage(driver);
        register=home.clickOnRegisterMenu();
        register.gender("Male");
        extentTest.get().log(Status.PASS, "Gender selected successfulyy");
        excel=new ExcelUtility();
        List<String> list=excel.readDataFromExcel("RegisterPage");
        System.out.println(list);
        register.enterFirstName(list.get(4));
        extentTest.get().log(Status.PASS, "First name entered successfully");
        register.enterlastName(list.get(5));
        extentTest.get().log(Status.PASS, "last name entered successfully");
        System.out.println(randomMail);
        register.enterRegEmail(randomMail);
        extentTest.get().log(Status.PASS, "email entered successfully");
        register.enterRegPassword(list.get(6));
        extentTest.get().log(Status.PASS, "password entered successfully");
        register.enterConfirmPassword(list.get(7));
        extentTest.get().log(Status.PASS, "confirm password entered successfully");
        account=register.registerButton();
        extentTest.get().log(Status.PASS, "clicked on registration button successfully");
        String actual=account.getTitleAccount();
        extentTest.get().log(Status.PASS, "Email address recieved successfully");
        String expected="Demo Web Shop. Register";
        Assert.assertEquals(actual,expected,"Invalid mail id");
        extentTest.get().log(Status.PASS, "User registarion passes successfully");
    }
}
