package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_HomePage;


public class socialMedia
{
    P01_HomePage homePage = new P01_HomePage();

    @Given("User is on the homepage")
    public void userIsOnTheHomepage()
    {
        homePage.HomePageAppears();
    }

    @When("User verifies the presence of social media icons")
    public void userVerifiesThePresenceOfSocialMediaIcons()
    {
        homePage.SocialMediaIcons();
    }

    @And("User clicks on the Facebook icon")
    public void userClicksOnTheFacebookIcon()
    {
     homePage.Facebook();
    }

    @Then("Facebook page should be opened")
    public void facebookPageShouldBeOpened()
    {
        homePage.FacebookOpened();
    }

    @When("User clicks on the Twitter icon")
    public void userClicksOnTheTwitterIcon()
    {
        homePage.twitter();
    }

    @Then("Twitter page should be opened")
    public void twitterPageShouldBeOpened()
    {
        homePage.TwitterOpened();
    }

    @When("User clicks on the RSS icon")
    public void userClicksOnTheRSSIcon()
    {
        homePage.rss();
    }

    @Then("RSS page should be opened")
    public void rssPageShouldBeOpened()
    {
        homePage.RssOpened();
    }

    @When("User clicks on the YouTube icon")
    public void userClicksOnTheYouTubeIcon()
    {
        homePage.youtube();
    }

    @Then("YouTube channel should be opened")
    public void youtubeChannelShouldBeOpened()
    {
        homePage.YoutubeOpened();
    }
}
