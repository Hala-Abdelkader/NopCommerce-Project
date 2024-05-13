package org.example.stepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Homepage;
import org.example.pages.P04_MyAccount;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.*;

public class D04_ChangeInfo {

    P00_Homepage homepage = new P00_Homepage();
    P04_MyAccount myAccount = new P04_MyAccount();
    Faker fake = new Faker();

    @Given("user navigates to My Account page")
    public void user_navigates_to_my_account_page() {
        homepage.gotoMyAccount();
    }
    @When("user changes gender to female")
    public void user_changes_gender_to_female() {
        myAccount.clickFemale();
    }
    @When("user changes Name")
    public void user_changes_name() {
        String firstName = fake.name().firstName();
        String lastName = fake.name().lastName();
        myAccount.sendFirstName(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
        myAccount.sendFirstName(firstName);
        myAccount.sendLastName(Keys.chord(Keys.CONTROL,"a"),Keys.BACK_SPACE);
        myAccount.sendLastName(lastName);

        targetJsonObject.put("FirstName",firstName);
        targetJsonObject.put("LastName",lastName);
        targetJsonObject.put("FullName",firstName.concat(" ").concat(lastName));
    }
    @When("user changes date of birthday")
    public void user_changes_date_of_birth() {
        Select selectDay = new Select(myAccount.getDay());
        String day = String.valueOf(fake.number().numberBetween(1,31));
        selectDay.selectByValue(day);

        Select selectMonth = new Select(myAccount.getMonth());
        String month = String.valueOf(fake.number().numberBetween(1,12));
        selectMonth.selectByValue(month);

        Select selectYear = new Select(myAccount.getYear());
        String year = String.valueOf(fake.number().numberBetween(1914,2024));
        selectYear.selectByValue(year);
        targetJsonObject.put("DD",day);
        targetJsonObject.put("MM",month);
        targetJsonObject.put("YY",year);

    }
    @When("user changes email")
    public void user_changes_email_to() {
        Faker fake = new Faker();
        myAccount.sendEmail(Keys.CONTROL,"a",Keys.BACK_SPACE);
        String email = fake.internet().safeEmailAddress();
        myAccount.sendEmail(email);
        targetJsonObject.put("EmailAddress",email);
    }
    @When("user clicks save")
    public void user_clicks_save() {
        myAccount.clickSave();
    }
    @Then("My Account info is Updated")
    public void my_account_info_is_updated() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(myAccount.getPopUpMsgText().equals("The customer info has been updated successfully."));
        String color = myAccount.getPopupMsgcolor();
        softAssert.assertEquals(Color.fromString(color).asHex(),"#4bb07a");
        softAssert.assertAll();
        jsonFlag=true;

    }


}
