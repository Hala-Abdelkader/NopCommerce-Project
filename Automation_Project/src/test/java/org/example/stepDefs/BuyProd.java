package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;
import org.example.pages.P03_LoginPage;
import org.example.pages.P04_BuyingProcess;


public class BuyProd
{
    P03_LoginPage login= new P03_LoginPage();
    P01_HomePage HomePg=new P01_HomePage();
    P04_BuyingProcess Buy =new P04_BuyingProcess();


    @Given("User login with valid data")
    public void Validlogin()
    {
        login.ClickLogin();
        login.EnterEmail();
        login.EnterCorrectPassword();
        login.ClickLoginBtn();
    }

    @When("User select product from featured products")
    public void userSelectProductFromFeaturedProducts()
    {
        HomePg.buyProd();
    }

    @And("User click on add to cart")
    public void userClickOnAddToCart()
    {
        Buy.AddToCart();
    }

    @And("User go to the shopping cart")
    public void userGoToTheShoppingCart()
    {
        HomePg.cart();
    }

    @And("User agree with the terms of service")
    public void userAgreeWithTheTermsOfService()
    {
        Buy.AgreeWithTerms();
    }

    @And("User click on checkout button")
    public void userClickOnCheckoutButton()
    {
        Buy.ClickOnCheckout();
    }


    @And("User enter the required data and click continue")
    public void userEnterTheRequiredData()
    {
        Buy.EnterRequiredData();
    }

    @And("User change shipping method and click continue")
    public void userChangeShippingMethod()
    {
        Buy.ChangeShipping();
    }

    @And("User select payment method and click continue")
    public void userSelectPaymentMethod()
    {
        Buy.SelectPaymentMethod();
    }

    @And("User confirm on order details")
    public void userConfirmOnOrderDetails()
    {
        Buy.ConfirmOrder();
    }

    @Then("Order is successfully processed")
    public void orderIsSuccessfullyProcessed()
    {
        Buy.ProcessCompleted();
    }

    @And("User is logged out")
    public void userIsLoggedOut()
    {
        Buy.Clicklogout();
    }
}
