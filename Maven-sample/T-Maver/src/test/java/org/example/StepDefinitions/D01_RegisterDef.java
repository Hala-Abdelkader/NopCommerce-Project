package org.example.StepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.example.pages.P00_Homepage;
import org.example.pages.P01_Registeration;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_RegisterDef{

    P00_Homepage homepage = new P00_Homepage();
    P01_Registeration register = new P01_Registeration();
    Faker fake = new Faker();

    @Given("user go to Registration page")
    public void user_go_to_registration_page() {
        homepage.gotoRegisteration();
    }

    @When("user select gender male")
    public void user_select_gender() {
        register.clickMale();
    }
    @When("user enters FirstName and Last Name")
    public void user_enters_first_name_and_last_name() {

        String firstName = fake.name().firstName();
        String lastName = fake.name().lastName();
        register.sendFirstName(firstName);
        register.sendLastName(lastName);
        System.out.println("Name : "+firstName+" "+lastName);
    }
    @When("user selects date of birth")
    public void user_selects_date_of_birth() {
        Select selectDay = new Select(register.getDay());
        String day = String.valueOf(fake.number().numberBetween(1,31));
        selectDay.selectByValue(day);

        Select selectMonth = new Select(register.getMonth());
        String month = String.valueOf(fake.number().numberBetween(1,12));
        selectMonth.selectByValue(month);

        Select selectYear = new Select(register.getYear());
        String year = String.valueOf(fake.number().numberBetween(1914,2024));
        selectYear.selectByValue(year);
        System.out.println("DOB : "+day+"/"+month+"/"+year);

    }
    @When("user enters valid email")
    public void user_enters_valid_email() {
        String email = fake.internet().safeEmailAddress();
        System.out.println("Email : "+email);
        register.sendEmail(email);

    }
    @When("user enters {string} as password")
    public void user_enters_as_password(String string) {
        register.sendPassword(string);
        register.sendConfirmPassword(string);

    }
    @When("user enters {string} as confirmation password")
    public void user_enter_as_confirmation_password(String string){
        register.sendConfirmPassword(string);
    }

    @When("user clicks on Register Button")
    public void user_clicks_on_register_button() {
        register.clickRegister();

    }
    @Then("Registration is Successful")
    public void registration_is_succesful() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(register.getSuccessMsg().contains("Your registration completed"));
        softAssert.assertAll();
    }


    @Then("User should see password unmatch error message")
    public void registration_Unsuccessfull(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(register.geterrorMessage().contains("The password and confirmation password do not match."));
        softAssert.assertAll();
    }

}
