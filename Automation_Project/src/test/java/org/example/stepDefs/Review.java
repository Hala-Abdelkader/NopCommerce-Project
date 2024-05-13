package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P05_ReviewProcess;

public class Review
{
    P05_ReviewProcess review =new P05_ReviewProcess();
    @When("User click on my account")
    public void Myaccount()
    {
        review.GotoMyAccount();
    }

    @And("User click on Orders")
    public void userClickOnOrders()
    {
        review.ClickOnOrders();
    }


    @And("User click on details")
    public void userClickOnDetails()
    {
        review.ClickOnDetails();
    }

    @And("User select a specific product from a previous order")
    public void userSelectASpecificProductFromAPreviousOrder()
    {
        review.ClickOnProd();
    }

    @And("User click on add review and write the review details")
    public void userClickOnAddReviewAndWriteTheReviewDetails()
    {
        review.ClickOnAddReview();
    }

    @Then("User Submit his review")
    public void userSubmitHisReview()
    {
        review.SubmitReview();
    }
}
