package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_RegPage;


public class Register {

    P02_RegPage registerPg =new P02_RegPage();


    @Given("User go to register page")
    public void RegisterPage()
    {
        registerPg.clickRegister();
    }

    @When("User select gender")
    public void userSelectGender()
    {
        registerPg.clickMale();
    }

    @And("User enter first name and last name")
    public void userEnter()
    {
        registerPg.setFirstNameandLastName();
    }

    @And("user select date of birth")
    public void userSelectDateOfBirth()
    {
        registerPg.setDateofBirth();
    }

    @And("user enter email")
    public void userEnterEmail()
    {
        registerPg.setEmail();
    }
    @And("user enter password and confirmation password")
    public void userEnterPassword()
    {
        registerPg.setPasswordandConfirm();
    }

    @And("user click on register button")
    public void userClickOnRegisterButton()
    {
        registerPg.ClickRegBtn();
    }

    @Then("account is created successfully")
    public void accountIsCreatedSuccessfully()
    {
        registerPg.SuccessMsg();
    }
}
