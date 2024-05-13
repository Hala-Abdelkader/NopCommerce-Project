package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Homepage;
import org.example.pages.P05_Browse;
import org.example.pages.P06_AddToCart;
import org.example.pages.P07_Checkout;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D05_Browse {
    P00_Homepage homepage = new P00_Homepage();
    P05_Browse shopping = new P05_Browse();
    P06_AddToCart cart = new P06_AddToCart();
    P07_Checkout checkout = new P07_Checkout();
    Faker fake = new Faker();


    @When("User search for a product")
    public void searchProduct() throws InterruptedException {
        shopping.sendProductName("HTC One M8 Android L 5.0 Lollipop");
        Thread.sleep(1000);
        shopping.clicksearch();
    }
    @When("User add the product to cart")
    public void addProduct() throws InterruptedException {
        shopping.addProduct();
    }
    @When ("User browse for books")
    public void browseBooks() throws InterruptedException {
        shopping.digital_Download();
    }
    @When ("User add a book to the cart")
    public void addBook() {
        shopping.addDigital();

    }
    @When("User go to the cart")
    public void gotoCart()  {
        homepage.gotoCart();
    }
    @When ("User remove the book from the cart")
    public void removeItem() throws InterruptedException {
        cart.removeItem();
    }






}
