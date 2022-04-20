package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    HomePage home;

    @Test(priority = 1,enabled = true,description = "TC_001_Verify Home Page Title")
    public void verifyHomePageTitle(){
        home=new HomePage(driver);
        String actualTitle=home.getHomePageTitle();
        String expectedTitle="Demo Web Shop";
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid HomePage Titles");
    }
}
