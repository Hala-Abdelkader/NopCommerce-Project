package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Set;

public class P00_Homepage {

    // Navigation
    By registerIcon = By.className("ico-register");
    By contactUsLink = By.cssSelector("a[href=\"/contactus\"]");
    By LoginLink = By.className("ico-login");
    By myAccountIcon = By.className("ico-account");
    By CartLink = By.className("ico-cart");

    // Social Media
    By facebook=By.className("facebook");
    By twitter=By.className("twitter");
    By rss=By.className("rss");
    By youtube=By.className("youtube");

    // Buy featured product
    By prod=By.linkText("HTC One M8 Android L 5.0 Lollipop");
    By Add_to_cart=By.className("add-to-cart-button");

    // Social Media Redirect
    public void clickFacebook()
    {
        Hooks.driver.findElement(facebook).click();
    }
    public void clickTwitter()
    {
        Hooks.driver.findElement(twitter).click();
    }
    public void clickRss()
    {
        Hooks.driver.findElement(rss).click();
    }
    public void clickYoutube()
    {
        Hooks.driver.findElement(youtube).click();
    }

    // Navigation
    public void gotoRegisteration(){
        Hooks.driver.findElement(registerIcon).click();
    }
    public void gotoContactUs(){
        Hooks.driver.findElement(contactUsLink).click();
    }
    public void gotoLogin(){
        Hooks.driver.findElement(LoginLink).click();
    }
    public void gotoMyAccount(){
        Hooks.driver.findElement(myAccountIcon).click();
    }
    public void gotoCart(){
        Hooks.driver.findElement(CartLink).click();
    }

    // Verifications
    public void HomePageAppears(){
        String expectedURL="https://demo.nopcommerce.com/";
        String actualURL=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }
    public void SocialMediaIcons(){
        Hooks.driver.findElement(facebook).isDisplayed();
        Hooks.driver.findElement(twitter).isDisplayed();
        Hooks.driver.findElement(rss).isDisplayed();
        Hooks.driver.findElement(youtube).isDisplayed();
    }
    public void FacebookOpened(){

        String mainWindowHandle = Hooks.driver.getWindowHandle();

        Set<String> allWindowHandles = Hooks.driver.getWindowHandles();

        // Iterate through window handles and switch to the new tab
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                Hooks.driver.switchTo().window(windowHandle);
                break;
            }
        }
        String expectedURL="https://www.facebook.com/nopCommerce";
        String actualURL=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

        Hooks.driver.close();

        // Switch back to the main window
        Hooks.driver.switchTo().window(mainWindowHandle);
    }
    public void TwitterOpened(){

        String mainWindowHandle = Hooks.driver.getWindowHandle();

        Set<String> allWindowHandles = Hooks.driver.getWindowHandles();

        // Iterate through window handles and switch to the new tab
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                Hooks.driver.switchTo().window(windowHandle);
                break;
            }
        }
        String expectedURL="https://twitter.com/nopCommerce";
        String actualURL=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

        Hooks.driver.close();

        // Switch back to the main window
        Hooks.driver.switchTo().window(mainWindowHandle);

    }
    public void RssOpened(){
        String expectedURL="https://demo.nopcommerce.com/news/rss/1";
        String actualURL=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);

        Hooks.driver.navigate().to("https://demo.nopcommerce.com/");
    }
    public void YoutubeOpened(){

        String mainWindowHandle = Hooks.driver.getWindowHandle();

        Set<String> allWindowHandles = Hooks.driver.getWindowHandles();

        // Iterate through window handles and switch to the new tab
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(mainWindowHandle)) {
                Hooks.driver.switchTo().window(windowHandle);
                break;
            }
        }
        String expectedURL="https://www.youtube.com/user/nopCommerce";
        String actualURL=Hooks.driver.getCurrentUrl();
        Assert.assertEquals(actualURL,expectedURL);
    }

    // Featured Product
    public void buyProd()
    {
        Hooks.driver.findElement(prod).click();
    }
    public void AddToCart()
    {
        Hooks.driver.findElement(Add_to_cart).click();
    }
}
