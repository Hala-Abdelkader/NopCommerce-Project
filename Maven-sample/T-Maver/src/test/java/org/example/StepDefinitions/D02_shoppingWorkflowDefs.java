package org.example.StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.example.pages.P00_Homepage;
import org.example.pages.P02_shoppingWorkflow;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D02_shoppingWorkflowDefs {
    P00_Homepage homepage = new P00_Homepage();
    P02_shoppingWorkflow shopping = new P02_shoppingWorkflow();
    Faker fake = new Faker();

    //Scenario One highest priority
    @Given("User navigate to the login page")
    public void login_page()
    {
        homepage.gotoLogin();
    }
    @When("User enter a valid username and password")
    public void enteruserandpass()
    {
        shopping.sendemail("abdallamohamed389@gmail.com");
        shopping.sendpassword("1234MMhh");
        shopping.loginButton();
    }

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
       shopping.gotocart();
    }
    @When ("User remove the book from the cart")
    public void removeItem() throws InterruptedException {
       shopping.removeItem();
    }
    @When ("User proceed to checkout")
    public void checkout() throws InterruptedException {
       shopping.termandService();
       shopping.checkout();
    }
    @When ("User provide invalid payment details")
    public void invalidPayment() throws InterruptedException {
        String city = fake.address().cityName();
        String address = fake.address().streetAddress();
        String zipcode =fake.address().zipCode();
        String phoneNumber = fake.phoneNumber().phoneNumber();
        String cardholderName = fake.name().fullName();
        String cardNumber = fake.business().creditCardNumber();

        shopping.city(city);
        shopping.address(address);
        shopping.phoneNumber(phoneNumber);
        shopping.zipcode(zipcode);
        shopping.phoneNumber(phoneNumber);
        shopping.clickaddressButton01(); //click continue button 1
        //shopping.clickshippingaddressButton02(); //click continue button 2
        shopping.paymentmethod();
        shopping.clickpaymentmethodbtn(); //click continue button 3
        shopping.cardholderName(cardholderName);
        shopping.cardNumber(cardNumber);

        Select selectMonth = new Select(shopping.getexpireMonth());
        String month = String.valueOf(fake.number().numberBetween(1,12));
        selectMonth.selectByValue(month);

        Select selectYear = new Select(shopping.getexpeireYear());
        String year = String.valueOf(fake.number().numberBetween(2025,2040));
        selectYear.selectByValue(year);

    }
    @Then("User should see a payment error message")
    public void errorMessage(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(shopping.errorMessage().contains("Wrong card number"));
        softAssert.assertAll();
    }



}
