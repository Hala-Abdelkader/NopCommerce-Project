package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.*;

public class P03_Login {

    By email = By.id("Email");
    By password = By.id("Password");
    By loginBtn = By.className("login-button");
    By FailMsg=By.className("message-error");
    By Forgotpass=By.className("forgot-password");
    By emailRec=By.className("email");
    By Recover=By.name("send-email");
    By SuccRec=By.className("content");

    public void sendEmail(CharSequence... keysToSend){
        Hooks.driver.findElement(email).sendKeys(keysToSend);
    }
    public void sendPassword(CharSequence... keysToSend){
        Hooks.driver.findElement(password).sendKeys(keysToSend);
    }
    public void clickLogin(){
        Hooks.driver.findElement(loginBtn).click();
    }

    public void FailMsg()
    {
        WebElement Fail=Hooks.driver.findElement(FailMsg);
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(Fail.getText().contains("Login was unsuccessful."));
        String actualColor=Fail.getCssValue("color");
        soft.assertEquals(Color.fromString(actualColor).asHex(),"#e4434b");
        soft.assertAll();
    }
    public void clickForgotPass()
    {
        Hooks.driver.findElement(Forgotpass).click();
    }
    public void sendEmailToRecover()
    {
        Hooks.driver.findElement(emailRec).sendKeys(testData.email);
    }
    public void clickRecover()
    {
        Hooks.driver.findElement(Recover).click();
    }
    public void AccountRecovered()
    {
        WebElement Success=Hooks.driver.findElement(SuccRec);
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(Success.getText().contains("Email with instructions"));
        soft.assertAll();
    }
}
