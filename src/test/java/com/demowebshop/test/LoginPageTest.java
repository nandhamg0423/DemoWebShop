package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.utilities.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginPageTest extends Base {
   HomePage home;
   LoginPage login;
   MyAccountPage account;
   ExcelUtility excel;
   @Test(priority = 2,enabled = true,description = "TC_002_Verify Valid User Login")
    public void verifyLogin() throws IOException {
       home=new HomePage(driver);
       login=home.clickOnLoginMenu();
       excel=new ExcelUtility();
       List<String> list=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx","LoginPage");
       System.out.println(list);
       login.enterUsername(list.get(3));
       login.enterPassword(list.get(4));
       account=login.clickOnLoginButton();
       String actual_mailId=account.getUsername();
       String expected_mailId=list.get(3);
       Assert.assertEquals(actual_mailId,expected_mailId,"User login Failed");
   }

   

   @Test(priority = 3,enabled = true,description = "TC_002_Verify Valid User Login",groups = {"smoke"})
   public void verifyLoginPageTitle() {
      home=new HomePage(driver);
      login=home.clickOnLoginMenu();
      String expectedTitle = "Demo Web Shop. Login";
      String actualTitle =login.getLoginPageTitle();
      Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
   }

}
