package org.example.pages;

import org.example.StepDefinitions.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class P02_shoppingWorkflow {
    By email = By.className("email");
    By password = By.className("password");
    By loginButton = By.xpath("//button[@type=\"submit\"]");
    By searchProduct = By.xpath("//input[@type=\"text\"]");
    By searchButton = By.xpath("//button[@type=\"submit\"]");
    By addProduct = By.xpath("//button[@type=\"button\"]");
    By browsefordigitalDownload = By.xpath("//a[@href=\"/digital-downloads\"]");
    By addDigital = By.xpath("//button[@type=\"button\"]");
    By gotocart = By.xpath("//a[@href=\"/cart\"]");
    By removeItem = By.xpath("//button[@class=\"remove-btn\"]");
    By termsandService = By.xpath("//input[@id=\"termsofservice\"]");
    By checkout = By.xpath("//button[@id=\"checkout\"]");
    By billingAddress_Country =By.id("BillingNewAddress_CountryId");
    By billingAddress_City = By.id("BillingNewAddress_City");
    By billingAddress_Address1 = By.id("BillingNewAddress_Address1");
    By billingAddress_Zipcode = By.id("BillingNewAddress_ZipPostalCode");
    By billingAddress_phoneNumber = By.id("BillingNewAddress_PhoneNumber");
    By AddressContiunebtn = By.id("save-billing-address-button");
   // By ShippingAddressContinuebtn = By.id("save-shipping-address-button");
    By contuneBtn = By.xpath("//button[@type=\"button\"]");

    By paymentmethod = By.id("paymentmethod_1");
    By cardholderName = By.xpath("//input[@type=\"text\"]");
    By cardNumber = By.xpath("//input[@type=\"text\"]");
    By expirationdate_year = By.id("ExpireYear");
    By expirationdate_Month = By.id("id=\"ExpireMonth\"");

    By errorMessage = By.className("validation-summary-errors");

    public void sendemail(CharSequence... keystosend){
        Hooks.driver.findElement(email).sendKeys(keystosend);
    }
    public void sendpassword(CharSequence... keystosend){
        Hooks.driver.findElement(password).sendKeys(keystosend);
    }
    public void loginButton(){
        Hooks.driver.findElements(loginButton).get(1).click();
    }
    public void sendProductName (CharSequence... keysToSend){
        Hooks.driver.findElement(searchProduct).sendKeys(keysToSend);
    }
    public void clicksearch(){
        Hooks.driver.findElement(searchButton).click();
    }
    public void addProduct(){
        Hooks.driver.findElements(addProduct).get(0).click();
    }
    public void digital_Download(){
        Hooks.driver.findElements(browsefordigitalDownload).get(0).click();
    }
    public void addDigital(){
        Hooks.driver.findElements(addDigital).get(4).click();
    }
    public void gotocart(){
        Hooks.driver.findElement(gotocart).click();
    }
    public void removeItem(){
        Hooks.driver.findElements(removeItem).get(1).click();
    }
    public void termandService(){
        Hooks.driver.findElement(termsandService).click();
    }
    public void checkout(){
        Hooks.driver.findElement(checkout).click();
    }
    public WebElement getcountry(){
        return Hooks.driver.findElement(billingAddress_Country);
    }
    public void city(CharSequence... keystosend){
        Hooks.driver.findElement(billingAddress_City).sendKeys(keystosend);
    }
    public void address(CharSequence... keystosend){
        Hooks.driver.findElement(billingAddress_Address1).sendKeys(keystosend);
    }
    public void zipcode(CharSequence... keystosend){
        Hooks.driver.findElement(billingAddress_Zipcode).sendKeys(keystosend);
    }
    public void phoneNumber(CharSequence... keystosend){
        Hooks.driver.findElement(billingAddress_phoneNumber).sendKeys(keystosend);
    }
    public void clickaddressButton01(){
        Hooks.driver.findElement(AddressContiunebtn).click();
    }
    //public void clickshippingaddressButton02(){
    //    Hooks.driver.findElement(ShippingAddressContinuebtn).click();
   // }
    public void clickshippingmehtodbtn(){
        Hooks.driver.findElements(contuneBtn).get(5).click();
    }
    public void paymentmethod(){
        Hooks.driver.findElement(paymentmethod).click();
    }

    public void clickpaymentmethodbtn(){
        Hooks.driver.findElements(contuneBtn).get(6).click();
    }
    public void cardholderName(CharSequence... keystosend){
        Hooks.driver.findElements(cardholderName).get(9).sendKeys(keystosend);
    }
    public void cardNumber(CharSequence... keystosend){
        Hooks.driver.findElements(cardNumber).get(10).sendKeys(keystosend);
    }
    public WebElement getexpeireYear(){
      return  Hooks.driver.findElement(expirationdate_year);
    }
    public WebElement getexpireMonth(){
      return   Hooks.driver.findElement(expirationdate_Month);
    }

    public void Continue04(){
        Hooks.driver.findElements(contuneBtn).get(7).click();

    }
    public String errorMessage(){
        return Hooks.driver.findElement(errorMessage).getText();
    }




}
