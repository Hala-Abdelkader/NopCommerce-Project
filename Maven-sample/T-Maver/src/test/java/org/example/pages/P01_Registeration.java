package org.example.pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P01_Registeration {

    By genderMale = By.id("gender-male");
    By genderFemale  = By.id("gender-female");
    By firstName  = By.id("FirstName");
    By lastName  = By.id("LastName");
    By day  = By.name("DateOfBirthDay");
    By month  = By.name("DateOfBirthMonth");
    By year  = By.name("DateOfBirthYear");
    By email  = By.id("Email");
    By password  = By.id("Password");
    By confirmPassword  = By.id("ConfirmPassword");
    By registerBtn  = By.id("register-button");
    By successMsg  = By.className("result");
    By errorMsg  = By.id("ConfirmPassword-error");

    public void clickMale(){
        Hooks.driver.findElement(genderMale).click();
    }
    public void clickFemale(){
        Hooks.driver.findElement(genderFemale).click();
    }
    public void clickRegister(){
        Hooks.driver.findElement(registerBtn).click();
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
    public void sendPassword(CharSequence... keysToSend){
        Hooks.driver.findElement(password).sendKeys(keysToSend);
    }
    public void sendConfirmPassword(CharSequence... keysToSend){
        Hooks.driver.findElement(confirmPassword).sendKeys(keysToSend);
    }

    public String getSuccessMsg(){
        return Hooks.driver.findElement(successMsg).getText();
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
    public String geterrorMessage(){
        return Hooks.driver.findElement(errorMsg).getText();
    }


}
