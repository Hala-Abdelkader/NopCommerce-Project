package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Homepage;
import org.example.pages.P09_ReviewProcess;

public class D08_Review
{
    P09_ReviewProcess review =new P09_ReviewProcess();
    P00_Homepage homepage = new P00_Homepage();
    @When("User click on my account")
    public void Myaccount()
    {
        homepage.gotoMyAccount();
    }

    @When("User click on Orders")
    public void userClickOnOrders()
    {
        review.clickOnOrders();
    }


    @When("User click on details")
    public void userClickOnDetails()
    {
        review.clickOnDetails();
    }

    @When("User select a specific product from a previous order")
    public void userSelectASpecificProductFromAPreviousOrder()
    {
        review.clickOnProd();
    }

    @When("User click on add review and write the review details")
    public void userClickOnAddReviewAndWriteTheReviewDetails()
    {
        review.clickOnAddReview();
    }

    @Then("User Submit his review")
    public void userSubmitHisReview()
    {
        review.SubmitReview();
    }
}
