package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P05_Browse {

    By searchProduct = By.xpath("//input[@type=\"text\"]");
    By searchButton = By.xpath("//button[@type=\"submit\"]");
    By addProduct = By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]");
    By browsefordigitalDownload = By.xpath("//a[@href=\"/digital-downloads\"]");
    By addDigital = By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]");

    By paymentmethod = By.id("paymentmethod_1");
    By cardholderName = By.id("CardholderName");
    By cardNumber = By.id("CardNumber");
    By expirationdate_year = By.id("ExpireYear");
    By expirationdate_Month = By.id("ExpireMonth");

    By errorMessage = By.className("validation-summary-errors");


    public void sendProductName (CharSequence... keysToSend){
        Hooks.driver.findElement(searchProduct).sendKeys(keysToSend);
    }
    public void clicksearch(){
        Hooks.driver.findElement(searchButton).click();
    }
    public void addProduct(){
        Hooks.driver.findElement(addProduct).click();
    }
    public void digital_Download(){
        Hooks.driver.findElements(browsefordigitalDownload).get(0).click();
    }
    public void addDigital(){
        Hooks.driver.findElements(addDigital).get(1).click();
    }

}





