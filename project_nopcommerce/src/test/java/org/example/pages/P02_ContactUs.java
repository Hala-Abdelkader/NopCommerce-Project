package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P02_ContactUs {

    By fullname = By.className("fullname");
    By email = By.className("email");
    By enquiry = By.className("enquiry");
    By sendBtn = By.name("send-email");
    By msgsent = By.className("result");
    By nameError = By.id("FullName-error");
    By emailError = By.id("Email-error");
    By enquiryError = By.id("Enquiry-error");

    public void sendFullName(CharSequence... keysToSend){
        Hooks.driver.findElement(fullname).sendKeys(keysToSend);
    }
    public void sendEmail(CharSequence... keysToSend){
        Hooks.driver.findElement(email).sendKeys(keysToSend);
    }
    public void sendEnquiry(CharSequence... keysToSend){
        Hooks.driver.findElement(enquiry).sendKeys(keysToSend);
    }
    public void clickSend(){
        Hooks.driver.findElement(sendBtn).click();
    }
    public WebElement getNameError(){
        return Hooks.driver.findElement(nameError);
    }
    public WebElement getEmailError(){
        return Hooks.driver.findElement(emailError);
    }
    public WebElement getEnquiryError(){
        return Hooks.driver.findElement(enquiryError);
    }
    public WebElement getConfirmMsg(){
        return Hooks.driver.findElement(msgsent);

    }
    public WebElement getNameField(){
        return Hooks.driver.findElement(fullname);
    }
    public WebElement getEmailField(){
        return Hooks.driver.findElement(email);
    }
    public WebElement getEnquiryField(){
        return Hooks.driver.findElement(enquiry);
    }

}
