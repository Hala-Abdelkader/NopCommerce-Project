package org.example.pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P00_Homepage {


    By registerIcon = By.className("ico-register");
    By contactUsLink = By.cssSelector("a[href=\"/contactus\"]");
    By LoginLink = By.className("ico-login");
    By myAccountIcon = By.className("ico-account");
    By CartLink = By.className("ico-cart");



    public void gotoRegisteration(){
        Hooks.driver.findElement(registerIcon).click();
    }
    public void gotoContactUs(){
        Hooks.driver.findElement(contactUsLink).click();
    }
    public void gotoLogin(){
        Hooks.driver.findElement(LoginLink).click();
    }
    public void gotoMyAccount(){
        Hooks.driver.findElement(myAccountIcon).click();
    }
    public void gotoCart(){
        Hooks.driver.findElement(CartLink).click();
    }

}
