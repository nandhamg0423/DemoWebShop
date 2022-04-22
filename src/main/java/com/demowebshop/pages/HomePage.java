package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends ObjectUtility {

    WebDriver driver;
    /**page constructor**/
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /**page elements**/
    private final String _loginMenu="li>a.ico-login";
    @FindBy(css= _loginMenu) private WebElement loginMenu;

    private final String _regMenu="//a[text()='Register']";
    @FindBy(xpath= _regMenu) private WebElement regMenu;
    /**User action methods**/

    public String getHomePageTitle() throws IOException {
        String title=page.getPageTitle(driver);
        String expected= String.valueOf(excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx","HomePage"));
        System.out.println(expected);
        //String actual="Demo Web Shop";
        return title;
    }
    public LoginPage clickOnLoginMenu(){
        page.clickOnElement(loginMenu);
        return new LoginPage(driver);
    }
    public RegisterPage clickOnRegisterMenu(){
        page.clickOnElement(regMenu);
        return new RegisterPage(driver);
    }

}
