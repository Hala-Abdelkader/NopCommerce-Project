package org.example.pages;

import org.example.stepDefs.Hooks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;


public class P03_LoginPage
{
    By loginLink=By.className("ico-login");

    By email=By.className("email");

    By password=By.className("password");

    By loginBtn=By.className("login-button");

    By FailMsg=By.className("message-error");

    By Forgotpass=By.className("forgot-password");

    By emailRec=By.className("email");

    By Recover=By.name("send-email");

   By SuccRec=By.className("content");

    public static String getEmailAddress() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData1.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("EmailAddress");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }

    public static String getWrongpassword() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("WrongPassword");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }

    public static String getCorrectpassword() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("Password");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }



    public void ClickLogin()
    {
        Hooks.driver.findElement(loginLink).click();
    }

    public void EnterEmail()
    {
        Hooks.driver.findElement(email).sendKeys(getEmailAddress());
    }

    public void EnterWrongPassword()
    {
        Hooks.driver.findElement(password).sendKeys(getWrongpassword());
    }

    public void EnterCorrectPassword()
    {
        Hooks.driver.findElement(password).sendKeys(getCorrectpassword());
    }



    public void ClickLoginBtn()
    {
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

    public void ForgotPass()
    {
        Hooks.driver.findElement(Forgotpass).click();
    }

    public void EnterEmailToRecover()
    {
        Hooks.driver.findElement(emailRec).sendKeys(getEmailAddress());
    }

    public void ClickRecover()
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
