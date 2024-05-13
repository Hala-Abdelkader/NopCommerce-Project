package org.example.pages;

import org.example.stepDefs.Hooks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import java.io.FileReader;


public class P05_ReviewProcess
{

    By myAccount= By.className("ico-account");
    By Orders=By.xpath("//a[contains(text(), 'Orders')]");
    By details=By.className("order-details-button");
    By ProdDes=By.xpath("//a[contains(text(),'HTC One M8 Android L 5.0 Lollipop')]");
    By Addreview=By.xpath("//a[contains(text(),'Add your review')]");
    By RevTitle=By.name("AddProductReview.Title");
    By RevText=By.name("AddProductReview.ReviewText");
    By RevRate=By.id("addproductrating_4");
    By SubRev=By.name("add-review");

    public static String getreviewTitle() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("ReviewTitle");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }

    public static String getReviewText() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
            JSONObject jsonObject = (JSONObject) obj;
            return (String) jsonObject.get("ReviewText");
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null or handle the error appropriately
        }
    }

    public void GotoMyAccount()
    {
        Hooks.driver.findElement(myAccount).click();
    }

    public void ClickOnOrders()
    {
        Hooks.driver.findElement(Orders).click();
    }

    public void ClickOnDetails()
    {
        Hooks.driver.findElement(details).click();
    }

    public void ClickOnProd()
    {
        Hooks.driver.findElement(ProdDes).click();
    }

    public void ClickOnAddReview()
    {
        Hooks.driver.findElement(Addreview).click();
        Hooks.driver.findElement(RevTitle).sendKeys(getreviewTitle());
        Hooks.driver.findElement(RevText).sendKeys(getReviewText());
        Hooks.driver.findElement(RevRate).click();
    }

    public void SubmitReview()
    {
        Hooks.driver.findElement(SubRev).click();
    }
}
