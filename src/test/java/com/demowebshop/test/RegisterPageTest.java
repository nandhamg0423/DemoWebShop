package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
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

    @Test(priority = 4,enabled = true,description = "TC_002_Verify Valid User Login")
    public void verifyRegisterPage() throws IOException {
        home=new HomePage(driver);
        register=home.clickOnRegisterMenu();
        register.gender("Male");
        excel=new ExcelUtility();
        List<String> list=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx","RegisterPage");
        System.out.println(list);
        register.enterFirstName(list.get(4));
        register.enterlastName(list.get(5));
        System.out.println(randomMail);
        register.enterRegEmail(randomMail);
        register.enterRegPassword(list.get(6));
        register.enterConfirmPassword(list.get(7));
        account=register.registerButton();
        String actual=account.getTitleAccount();
        String expected="Demo Web Shop. Register";
        Assert.assertEquals(actual,expected,"Invalid mail id");
    }
}
