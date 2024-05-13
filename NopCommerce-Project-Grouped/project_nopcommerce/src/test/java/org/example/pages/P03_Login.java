package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P03_Login {

    By email = By.id("Email");
    By password = By.id("Password");
    By loginBtn = By.className("login-button");

    public void sendEmail(CharSequence... keysToSend){
        Hooks.driver.findElement(email).sendKeys(keysToSend);
    }
    public void sendPassword(CharSequence... keysToSend){
        Hooks.driver.findElement(password).sendKeys(keysToSend);
    }
    public void clickLogin(){
        Hooks.driver.findElement(loginBtn).click();
    }

}
