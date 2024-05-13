package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P11_browseTag;
import org.testng.asserts.SoftAssert;

public class D10_productTageDefs {
        P11_browseTag tags = new P11_browseTag();
    @Given ("User browse computers category")
    public void browseTags(){
        tags.ClickComputer();
    }
    @When ("User click view all tags")
    public void viewTage(){
        tags.clickViewAll();

    }
    @Then ("User should see all the tags")
    public void checkTagsPage(){
        SoftAssert soft = new SoftAssert();

        String actualUrl = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/producttag/all";
        soft.assertEquals(actualUrl,expectedUrl,"Second assert Failed");


        String actualText = tags.PageTitle();
        String expectedText = "All product tags";
        soft.assertEquals(actualText,expectedText,"First assertion failed");

        soft.assertAll();
    }

    @And ("User click on shoes tag")
    public void chooseTag(){
        tags.ChooseTag();
    }
    @Then ("User show see the product under this tags")
    public void checkProducts(){
        SoftAssert soft = new SoftAssert();
        String actualUrl = Hooks.driver.getCurrentUrl();
        String expectedUrl = "https://demo.nopcommerce.com/shoes-2";
        soft.assertEquals(actualUrl,expectedUrl,"Third assertion failed");

        String actualPagetitle = tags.PageTitle();
        String expectedPagetitle = "Products tagged with 'shoes'";

        soft.assertAll();

    }
}
