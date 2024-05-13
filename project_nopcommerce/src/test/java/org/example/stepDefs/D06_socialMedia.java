package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P00_Homepage;


public class D06_socialMedia
{
    P00_Homepage homePage = new P00_Homepage();

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
     homePage.clickFacebook();
    }

    @Then("Facebook page should be opened")
    public void facebookPageShouldBeOpened()
    {
        homePage.FacebookOpened();
    }

    @When("User clicks on the Twitter icon")
    public void userClicksOnTheTwitterIcon()
    {
        homePage.clickTwitter();
    }

    @Then("Twitter page should be opened")
    public void twitterPageShouldBeOpened()
    {
        homePage.TwitterOpened();
    }

    @When("User clicks on the RSS icon")
    public void userClicksOnTheRSSIcon()
    {
        homePage.clickRss();
    }

    @Then("RSS page should be opened")
    public void rssPageShouldBeOpened()
    {
        homePage.RssOpened();
    }

    @When("User clicks on the YouTube icon")
    public void userClicksOnTheYouTubeIcon()
    {
        homePage.clickYoutube();
    }

    @Then("YouTube channel should be opened")
    public void youtubeChannelShouldBeOpened()
    {
        homePage.YoutubeOpened();
    }
}
