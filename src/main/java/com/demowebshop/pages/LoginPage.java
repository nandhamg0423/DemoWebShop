package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor**/

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /**page elements**/

    private final String _username="//input[@id='Email']";
    @FindBy(xpath= _username) private WebElement username;

    private final String _password="//input[@id='Password']";
    @FindBy(xpath= _password) private WebElement password;

    private final String _loginButton="//input[@class='button-1 login-button']";
    @FindBy(xpath= _loginButton) private WebElement loginButton;

    /**User action methods**/

    public void enterUsername(String uName){
        page.enterText(username,uName);
    }
    public void enterPassword(String pWord){
        page.enterText(password,pWord);
    }
    public MyAccountPage clickOnLoginButton(){
        page.clickOnElement(loginButton);
        return new MyAccountPage(driver);
    }
}
