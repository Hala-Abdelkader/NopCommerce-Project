package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P08_ProductPage {


    By addtoCart_Btn = By.id("add-to-cart-button-2");

    public void clickAddtoCart(){
        Hooks.driver.findElement(addtoCart_Btn).click();
    }

}
