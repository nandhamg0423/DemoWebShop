package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
   HomePage home;
   LoginPage login;
   MyAccountPage account;

   @Test(priority = 2,enabled = true,description = "TC_002_Verify Valid User Login")
    public void verifyLogin(){
       home=new HomePage(driver);
       login=home.clickOnLoginMenu();
       login.enterUsername("nandhamg5079@gmail.com");
       login.enterPassword("123456");
       account=login.clickOnLoginButton();
       String actual_mailId=account.getUsername();
       String expected_mailId="nandhamg5079@gmail.com";
       Assert.assertEquals(actual_mailId,expected_mailId,"User login Failed");
   }
}
