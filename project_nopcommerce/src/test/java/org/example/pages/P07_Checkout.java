package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.stepDefs.Hooks.driver;

public class P07_Checkout {

    By addressList = By.id("billing-address-select");
    By country = By.id("BillingNewAddress_CountryId");
    By city = By.id("BillingNewAddress_City");
    By address1 = By.id("BillingNewAddress_Address1");
    By zipCode = By.id("BillingNewAddress_ZipPostalCode");
    By phone = By.id("BillingNewAddress_PhoneNumber");
    By addressContinueBtn = By.className("new-address-next-step-button");
    By groundShipping = By.id("shippingoption_0");
    By nextDayAirShipping = By.id("shippingoption_1");
    By secondDayAirShipping = By.id("shippingoption_2");
    By shippingContinueBtn = By.className("shipping-method-next-step-button");
    By cheque = By.id("paymentmethod_0");
    By card = By.id("paymentmethod_1");
    By cardType = By.id("CreditCardType");
    By cardHolderName = By.id("CardholderName");
    By cardNumber = By.id("CardNumber");
    By expirationdate_year = By.id("ExpireYear");
    By expirationdate_Month = By.id("ExpireMonth");
    By paymentMContinueBtn = By.className("payment-method-next-step-button");
    By paymentIContinueBtn = By.className("payment-info-next-step-button");
    By confirmBtn = By.className("confirm-order-next-step-button");
    By Success=By.xpath("//strong[contains(text(), 'Your order has been successfully processed!')]");
    By orderNumber= By.className("order-number");
    By errorMessage = By.className("validation-summary-errors");

    public void clickGroundShipping(){

        Hooks.driver.findElement(groundShipping).click();
    }
    public void clickCheque(){
        Hooks.driver.findElement(cheque).click();
    }
    public void clickAddressContinue(){
        Hooks.driver.findElement(addressContinueBtn).click();
    }
    public void clickShippingContinue(){
        Hooks.driver.findElement(shippingContinueBtn).click();
    }
    public void clickPaymentMContinue(){
        Hooks.driver.findElement(paymentMContinueBtn).click();
    }
    public void clickPaymentIContinue(){
        Hooks.driver.findElement(paymentIContinueBtn).click();
    }
    public void clickConfirm(){
        Hooks.driver.findElement(confirmBtn).click();
    }
    public void clickCard(){
        Hooks.driver.findElement(card).click();
    }

    public void sendCity(CharSequence... keysToSend){
        Hooks.driver.findElement(city).sendKeys(keysToSend);
    }
    public void sendAddress1(CharSequence... keysToSend){
        Hooks.driver.findElement(address1).sendKeys(keysToSend);
    }
    public void sendZipCode(CharSequence... keysToSend){
        Hooks.driver.findElement(zipCode).sendKeys(keysToSend);
    }
    public void sendPhone(CharSequence... keysToSend){
        Hooks.driver.findElement(phone).sendKeys(keysToSend);
    }
    public void cardholderName(CharSequence... keystosend){
        Hooks.driver.findElement(cardHolderName).sendKeys(keystosend);
    }
    public void cardNumber(CharSequence... keystosend){
        Hooks.driver.findElement(cardNumber).sendKeys(keystosend);
    }
    public WebElement getexpireYear(){
        return  Hooks.driver.findElement(expirationdate_year);
    }
    public WebElement getexpireMonth(){
        return   Hooks.driver.findElement(expirationdate_Month);
    }

    public WebElement getAddressList(){
        return Hooks.driver.findElement(addressList);
    }
    public WebElement getCountry(){
        return Hooks.driver.findElement(country);
    }
    public WebElement getErrorMessage(){
        return Hooks.driver.findElement(errorMessage);
    }
    public void ProcessCompleted(){
        Hooks.driver.findElement(confirmBtn).click();
        WebElement order_Number = Hooks.driver.findElement(orderNumber);
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(order_Number.isDisplayed());
        soft.assertAll();
    }

    public boolean isNotDisplayed() {
        try
        {
            if(getAddressList().isDisplayed())
            {
                return false;
            }
            return false;
        }
        catch(Exception e)
        {
            return true;
        }
    }

}
