package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_LoginPage;


public class InvalidLogin
{
    P03_LoginPage login= new P03_LoginPage();

    @Given("User go to login page")
    public void login()
     {
        login.ClickLogin();
     }

   @When("User Enter the email")
   public void userEnterInTheEmail()
    {
        login.EnterEmail();
    }

    @And("User enter password")
    public void userEnterInPassword()
    {
        login.EnterWrongPassword();
    }

    @And("User click on login button")
    public void userClickOnLoginButton()
    {
        login.ClickLoginBtn();
    }

    @Then("User can't login successfully")
    public void userCanTLoginSuccessfully()
    {
        login.FailMsg();
    }

    @And("User click on forget password")
    public void userClickOnForgetPassword()
    {
        login.ForgotPass();
    }

    @When("User write his recovery email address")
    public void userWriteHisEmailAddress()
    {
        login.EnterEmailToRecover();
    }

    @And("User click on recover button")
    public void userClickOnRecoverButton()
    {
        login.ClickRecover();
    }

    @Then("the account is recovered successfully")
    public void theAccountIsRecoveredSuccessfully()
    {
        login.AccountRecovered();
    }
}
