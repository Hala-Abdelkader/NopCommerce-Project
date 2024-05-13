package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Homepage;
import org.example.pages.P06_AddToCart;
import org.example.pages.P07_Checkout;
import org.example.pages.P08_ProductPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.*;

public class D05_BuyProductDef {

    P00_Homepage homepage = new P00_Homepage();
    P08_ProductPage product = new P08_ProductPage();
    P06_AddToCart cart = new P06_AddToCart();
    P07_Checkout checkout = new P07_Checkout();

    @When("User Navigates to Performance PC Product Page")
    public void user_navigates_to_performance_pc_product_page() {
        Hooks.driver.navigate().to(testData.product_url);
    }
    @When("User Clicks on Add to Cart")
    public void user_clicks_on_add_to_cart() {
        product.clickAddtoCart();
    }
    @When("User Clicks on Shopping Cart Icon")
    public void user_clicks_on_shopping_cart_icon() {
        homepage.gotoCart();
    }
    @When("User Clicks on Checkout")
    public void user_clicks_on_checkout() {
        cart.clickTermsofService();
        cart.clickCheckout();
    }
    @When("User Enter Valid Credentials")
    public void user_enter_valid_credentials() {
        if(checkout.isNotDisplayed()){
            Faker fake = new Faker();
            Select select = new Select(checkout.getCountry());
            select.selectByValue(testData.countryValue);
            checkout.sendCity(testData.city);
            String address =fake.address().streetAddress();
            String zipCode =fake.address().zipCode();
            String phone =fake.phoneNumber().cellPhone();
            checkout.sendAddress1(address);
            checkout.sendZipCode(zipCode);
            checkout.sendPhone(phone);
            targetJsonObject.put("Address",address);
            targetJsonObject.put("ZipCode",zipCode);
            targetJsonObject.put("PhoneNumber",address);
        }
        checkout.clickAddressContinue();
    }
    @When("User Chooses Ground Shipping Method")
    public void user_chooses_ground_shipping_method() {
        checkout.clickGroundShipping();
        checkout.clickShippingContinue();
    }
    @When("User Chooses Cheque Payment Method")
    public void user_chooses_check_payment_method() {
        checkout.clickCheque();
        checkout.clickPaymentMContinue();
    }
    @When("User Clicks On Continue in Payment Info Section")
    public void user_clicks_on_continue_in_payment_info_section() {
        checkout.clickPaymentIContinue();
    }
    @When("User Clicks On Confirm Button")
    public void user_clicks_on_confirm_button() {
        checkout.clickConfirm();
    }
    @Then("Window is Redirected to Thank you Page")
    public void window_is_redirected_to_thank_you_page() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/checkout/completed");
        softAssert.assertTrue(checkout.getOrderNumber().isDisplayed());
        jsonFlag=true;
    }




}
