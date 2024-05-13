package org.example.pages;

import org.example.stepDefs.Hooks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.FileReader;

public class P04_BuyingProcess
{
   By Add_to_cart=By.className("add-to-cart-button");
   By service=By.id("termsofservice");
   By checkout=By.id("checkout");
   By Country=By.id("BillingNewAddress_CountryId");
   By city=By.name("BillingNewAddress.City");
   By Address=By.name("BillingNewAddress.Address1");
   By ZipCode=By.name("BillingNewAddress.ZipPostalCode");
   By PhoneNumber=By.name("BillingNewAddress.PhoneNumber");
   By Continue=By.name("save");
   By option=By.id("shippingoption_1");
   By Continue2=By.className("shipping-method-next-step-button");
   By payment=By.id("paymentmethod_0");
   By Continue3=By.className("payment-method-next-step-button");
   By Continue4=By.className("payment-info-next-step-button");
   By Confirm=By.className("confirm-order-next-step-button");
   By Success=By.xpath("//strong[contains(text(), 'Your order has been successfully processed!')]");
   By logout=By.className("ico-logout");

    public static String getcity() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("City");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }

    public static String getaddress() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("Address");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }

    public static String getzipCode() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("ZipCode");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }


    public static String getPhoneNumber() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("PhoneNumber");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }


   public void AddToCart()
   {
       Hooks.driver.findElement(Add_to_cart).click();
   }

   public void AgreeWithTerms()
   {
       Hooks.driver.findElement(service).click();
   }

   public void ClickOnCheckout()
   {
       Hooks.driver.findElement(checkout).click();
   }

   public void EnterRequiredData()
   {
       WebElement country=Hooks.driver.findElement(Country);
       country.sendKeys(Keys.ARROW_DOWN);
       country.sendKeys(Keys.ARROW_DOWN);
       country.click();
       Hooks.driver.findElement(city).sendKeys(getcity());
       Hooks.driver.findElement(Address).sendKeys(getaddress());
       Hooks.driver.findElement(ZipCode).sendKeys(getzipCode());
       Hooks.driver.findElement(PhoneNumber).sendKeys(getPhoneNumber());
       Hooks.driver.findElement(Continue).click();
   }

   public void ChangeShipping()
   {
       Hooks.driver.findElement(option).click();
       Hooks.driver.findElement(Continue2).click();
   }

   public void SelectPaymentMethod()
   {
       Hooks.driver.findElement(payment).click();
       Hooks.driver.findElement(Continue3).click();
   }

   public void ConfirmOrder()
   {
       Hooks.driver.findElement(Continue4).click();
   }

   public void ProcessCompleted()
   {
       Hooks.driver.findElement(Confirm).click();
       WebElement SuccessMsg=Hooks.driver.findElement(Success);
       SoftAssert soft= new SoftAssert();
       soft.assertTrue(SuccessMsg.getText().contains("Your order has been successfully processed!"));
       soft.assertAll();
   }

   public void Clicklogout()
   {
       Hooks.driver.findElement(logout).click();
   }








}
