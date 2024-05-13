package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P04_MyAccount {

    By genderMale = By.id("gender-male");
    By genderFemale = By.id("gender-female");
    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By day = By.name("DateOfBirthDay");
    By month = By.name("DateOfBirthMonth");
    By year = By.name("DateOfBirthYear");
    By email = By.id("Email");
    By saveBtn = By.id("save-info-button");
    By popupMsgtext = By.cssSelector("p[class=\"content\"]");
    By popupMsgcolor = By.className("bar-notification");

    public void clickMale(){
        Hooks.driver.findElement(genderMale).click();
    }
    public void clickFemale(){
        Hooks.driver.findElement(genderFemale).click();
    }
    public void clickSave(){
        Hooks.driver.findElement(saveBtn).click();
    }

    public void sendFirstName(CharSequence... keysToSend){
        Hooks.driver.findElement(firstName).sendKeys(keysToSend);
    }
    public void sendLastName(CharSequence... keysToSend){
        Hooks.driver.findElement(lastName).sendKeys(keysToSend);
    }
    public void sendEmail(CharSequence... keysToSend){
        Hooks.driver.findElement(email).sendKeys(keysToSend);
    }

    public WebElement getDay(){
        return Hooks.driver.findElement(day);
    }
    public WebElement getMonth(){
        return Hooks.driver.findElement(month);
    }
    public WebElement getYear(){
        return Hooks.driver.findElement(year);
    }

    public String getPopUpMsgText(){
       return Hooks.driver.findElement(popupMsgtext).getText();
    }

    public String getPopupMsgcolor() {
        return Hooks.driver.findElement(popupMsgcolor).getCssValue("background-color");
    }
}
