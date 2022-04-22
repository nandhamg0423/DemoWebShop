package com.demowebshop.pages;

import com.demowebshop.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;

    /**page constructor**/

    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    /**page elements**/

    private final String _accountEmail="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath= _accountEmail) private WebElement accountEmail;

    private final String _accountTitle="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath= _accountTitle) private WebElement accountTitle;

    /**user action methods**/
    public String getUsername(){
        String emailId=page.getElementText(accountEmail);
        return emailId;
    }
    public String getTitleAccount(){
        String pageT=page.getPageTitle(driver);
        return pageT;
    }
}
