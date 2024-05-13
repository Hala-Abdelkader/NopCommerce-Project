package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Homepage;
import org.example.pages.P03_Login;

import static org.example.stepDefs.Hooks.*;


public class D07_InvalidLogin
{
    P00_Homepage homepage = new P00_Homepage();
    P03_Login login= new P03_Login();

    @Given("User go to login page")
    public void login()
     {
        homepage.gotoLogin();
     }

   @When("User Enter the email")
   public void userEnterInTheEmail()
    {
        login.sendEmail(testData.email);
    }

    @When("User enter password")
    public void userEnterInPassword(){
        Faker fake = new Faker();
        String pass = fake.internet().password();
        login.sendPassword(pass);
    }

    @When("User click on login button")
    public void userClickOnLoginButton()
    {
        login.clickLogin();
    }

    @Then("User can't login successfully")
    public void userCanTLoginSuccessfully()
    {
        login.FailMsg();
    }

    @When("User click on forget password")
    public void userClickOnForgetPassword()
    {
        login.clickForgotPass();
    }

    @When("User write his recovery email address")
    public void userWriteHisEmailAddress()
    {
        login.sendEmailToRecover();
    }

    @When("User click on recover button")
    public void userClickOnRecoverButton()
    {
        login.clickRecover();
    }

    @Then("the account is recovered successfully")
    public void theAccountIsRecoveredSuccessfully()
    {
        login.AccountRecovered();
    }
}
