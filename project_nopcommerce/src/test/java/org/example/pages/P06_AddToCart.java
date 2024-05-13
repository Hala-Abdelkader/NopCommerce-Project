package org.example.pages;

import io.cucumber.messages.types.Hook;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P06_AddToCart {

    By termsofService = By.id("termsofservice");
    By checkoutBtn = By.id("checkout");

    public void clickTermsofService(){
        Hooks.driver.findElement(termsofService).click();
    }
    public void clickCheckout(){
        Hooks.driver.findElement(checkoutBtn).click();
    }
}
