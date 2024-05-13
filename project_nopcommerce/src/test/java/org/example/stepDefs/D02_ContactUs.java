package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pages.P00_Homepage;
import org.example.pages.P02_ContactUs;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D02_ContactUs {

    P00_Homepage homepage = new P00_Homepage();
    P02_ContactUs contactUs = new P02_ContactUs();
    Faker fake = new Faker();
    @Given("user go to Contact Us page")
    public void user_go_to_contact_us_page() {
        homepage.gotoContactUs();
    }


    @When("user enters name")
    public void userEntersName() {
        String name = fake.name().fullName();
        contactUs.sendFullName(name);
    }

    @When("user enters email")
    public void userEntersEmail() {
        String email = fake.internet().safeEmailAddress();
        contactUs.sendEmail(email);
    }

    @When("user enters inquiry")
    public void userEntersInquiry() {
        String enquiry = fake.gameOfThrones().quote();
       contactUs.sendEnquiry(enquiry);
    }

    @When("user clicks submit")
    public void userClicksSubmit() {
        contactUs.clickSend();

    }

    @Then("user sees message sent successfully")
    public void userSeesMessage() {
        Assert.assertTrue(contactUs.getConfirmMsg().isDisplayed());

    }

    @Then("all fields in Contact Us are empty")
    public void allFieldsInContactUsAreEmpty() {
        contactUs.getNameField().clear();
        contactUs.getEmailField().clear();
        contactUs.getEnquiryField().clear();
    }

    @Then("error popups should be displayed")
    public void errorPopupsShouldBeDisplayed() {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(contactUs.getNameError().isDisplayed());
        softAssert.assertTrue(contactUs.getEmailError().isDisplayed());
        softAssert.assertTrue(contactUs.getEnquiryError().isDisplayed());
        softAssert.assertAll();
    }
}
