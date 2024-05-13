package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.example.pages.P00_Homepage;
import org.example.pages.P01_Register;
import org.json.simple.JSONObject;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.example.stepDefs.Hooks;

import java.io.FileWriter;

public class D01_RegisterDef {

    P00_Homepage homepage = new P00_Homepage();
    P01_Register register = new P01_Register();
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
        System.out.println("Name : " + firstName + " " + lastName);
        Hooks.targetJsonObject.put("FirstName", firstName);
        Hooks.targetJsonObject.put("LastName", lastName);
        String fullName = firstName.concat(" ").concat(lastName);
        Hooks.targetJsonObject.put("FullName", fullName);



    }

    @When("user selects date of birth")
    public void user_selects_date_of_birth() {
        Select selectDay = new Select(register.getDay());
        String day = String.valueOf(fake.number().numberBetween(1, 31));
        selectDay.selectByValue(day);

        Select selectMonth = new Select(register.getMonth());
        String month = String.valueOf(fake.number().numberBetween(1, 12));
        selectMonth.selectByValue(month);

        Select selectYear = new Select(register.getYear());
        String year = String.valueOf(fake.number().numberBetween(1914, 2024));
        selectYear.selectByValue(year);
        System.out.println("DOB : " + day + "/" + month + "/" + year);
        Hooks.targetJsonObject.put("DD", day);
        Hooks.targetJsonObject.put("MM", month);
        Hooks.targetJsonObject.put("YY", year);

    }

    @When("user enters valid email")
    public void user_enters_valid_email() {
        String email = fake.internet().safeEmailAddress();
        System.out.println("Email : " + email);
        register.sendEmail(email);
        Hooks.targetJsonObject.put("EmailAddress", email);

    }

    @When("user enters valid password")
    public void user_enters_valid_password() {
        String pass = fake.internet().password();
        register.sendPassword(pass);
        register.sendConfirmPassword(pass);
        Hooks.targetJsonObject.put("Password", pass);

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
        Hooks.jsonFlag=true;
    }

    @And("user enters {string} as password")
    public void userEntersAsPassword(String arg0) {
        register.sendPassword(arg0);
    }

    @And("user enters {string} as confirmation password")
    public void userEntersAsConfirmationPassword(String arg0) {
        register.sendConfirmPassword(arg0);
    }

    @Then("User should see password unmatch error message")
    public void userShouldSeePasswordUnmatchErrorMessage() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(register.geterrorMessage().contains("The password and confirmation password do not match."));
        softAssert.assertAll();
    }
}


