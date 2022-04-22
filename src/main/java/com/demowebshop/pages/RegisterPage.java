package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import com.demowebshop.utilities.RandomDataUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class RegisterPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor**/

    public RegisterPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }


    /**page element**/

    private final String _gender = "//label[@class='forcheckbox']";
    @FindBy(xpath = _gender)
    private WebElement gender;

    private final String _firstname = "//input[@id='FirstName']";
    @FindBy(xpath = _firstname)
    private WebElement firstname;

    private final String _lastname = "//input[@class='text-box single-line'and@id='LastName']";
    @FindBy(xpath = _lastname)
    private WebElement lastname;

    private final String _regemail = "//input[contains(@id,'Email')]";
    @FindBy(xpath = _regemail)
    private WebElement regemail;

    private final String _regPassword = "//input[@class='text-box single-line password'and@id='Password']";
    @FindBy(xpath = _regPassword)
    private WebElement regPassword;

    private final String _confirmPassword = "//input[@class='text-box single-line password'and@id='ConfirmPassword']";
    @FindBy(xpath = _confirmPassword)
    private WebElement confirmPassword;

    private final String _registerButton = "//input[contains(@id,'register-button')]";
    @FindBy(xpath = _registerButton)
    private WebElement registerButton;

    /**user action method**/

    public void gender(String gender) {
        List<WebElement> elementList = driver.findElements(By.xpath("//label[@class='forcheckbox']"));
        for (int i = 0; i < elementList.size(); i++) {
            if (elementList.get(i).getText().equals(gender)) {
                elementList.get(i).click();
            }
        }
    }

    public void enterFirstName(String fname){
        page.enterText(firstname,fname);
    }
    public void enterlastName(String lname){
        page.enterText(lastname,lname);
    }
    public void enterRegEmail(String remail){
        page.enterText(regemail,remail);
    }
    public void enterRegPassword(String rpass){
        page.enterText(regPassword,rpass);
    }
    public void enterConfirmPassword(String confpass){
        page.enterText(confirmPassword,confpass);
    }
    public MyAccountPage registerButton(){
        page.clickOnElement(registerButton);
        return new MyAccountPage(driver);
    }
}
