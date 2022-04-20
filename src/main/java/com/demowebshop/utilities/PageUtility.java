package com.demowebshop.utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class PageUtility {
    /**web driver commands**/

    public String getPageTitle(WebDriver driver){
    String title=driver.getTitle();
        return title;
    }
    public String getSourceCode(WebDriver driver){
        String sourcecode=driver.getPageSource();
        return sourcecode;
    }

    /**Web Element Commands**/

    public void clickOnElement(WebElement element){
        element.click();
    }
    public void enterText(WebElement element,String value){
        element.sendKeys(value);
    }
    public String getAttributeValue(WebElement element,String attribute){
        String value=element.getAttribute(attribute);
        return value;
    }
    public boolean isElementEnabled(WebElement element){
        boolean status=element.isEnabled();
        return status;
    }
    public boolean isElementDisplayed(WebElement element){
        boolean status=element.isDisplayed();
        return status;
    }
    public boolean isElementSelected(WebElement element){
        boolean status=element.isSelected();
        return status;
    }
    public String getElementText(WebElement element){
        String textvalue=element.getText();
        return textvalue;
    }

    /**selenium commands**/

    /**Handling alert**/

    public void acceptAlert(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    public void dismissAlert(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        alert.dismiss();
    }
    public String getAlertText(WebDriver driver){
        Alert alert=driver.switchTo().alert();
        String value=alert.getText();
         return value;
    }
    public String enterValueonAlert(WebDriver driver,String value){
        Alert alert=driver.switchTo().alert();
        alert.sendKeys(value);
        return value;
    }
    /**Handling dropdowns**/

    public String dropdownOptionByVisibleTest(WebElement element,String value){
        Select select=new Select(element);
        select.selectByVisibleText(value);
        return value;
    }
    public int dropdownOptionByIndex(WebElement element,int value){
        Select select=new Select(element);
        select.selectByIndex(value);
        return value;
    }
    public String dropdownOptionByValue(WebElement element,String value){
        Select select=new Select(element);
        select.selectByValue(value);
        return value;
    }
    public Object dropDownGetFirstselected(WebElement element){
        Select select=new Select(element);
        WebElement element1=select.getFirstSelectedOption();
        return element1;
    }
    public ArrayList<String> getAllSelectedDropDownValues(WebElement element){
        Select select = new Select(element);
        List<WebElement> list = select.getAllSelectedOptions();
        ArrayList<String> allSelected = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            allSelected.add(list.get(i).getText());
        }
        return allSelected;
    }
    public ArrayList<String> getAllDropdownValues(WebElement element){
        Select select = new Select(element);
        List<WebElement> list = select.getOptions();
        ArrayList<String> allOptions = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            allOptions.add(list.get(i).getText());
        }
        return allOptions;
    }
    public void deSelectAllDropDownValues(WebElement element){
        Select select=new Select(element);
        select.deselectAll();
    }
    public String navigateToAnotherTab(WebDriver driver){
        String window = driver.getWindowHandle();
        return window;
    }
    public Set<String> navigateToAnotherWindowTab(WebDriver driver) {
        Set<String> windows = driver.getWindowHandles();
        return windows;
    }
    public static String random(){
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(1000);
        String email="testmail"+ randomInt +"@gmail.com";
        return email;
    }
}
