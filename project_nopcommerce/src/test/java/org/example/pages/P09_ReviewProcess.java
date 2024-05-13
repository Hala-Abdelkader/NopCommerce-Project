package org.example.pages;

import org.example.stepDefs.Hooks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;

import java.io.FileReader;
import static org.example.stepDefs.Hooks.*;


public class P09_ReviewProcess
{

    By Orders=By.xpath("//a[contains(text(), 'Orders')]");
    By details=By.className("order-details-button");
    By ProdDes=By.xpath("//a[contains(text(),'Digital Storm VANQUISH 3 Custom Performance PC')]");
    By Addreview=By.xpath("//a[contains(text(),'Add your review')]");
    By RevTitle=By.name("AddProductReview.Title");
    By RevText=By.name("AddProductReview.ReviewText");
    By RevRate=By.id("addproductrating_4");
    By SubRev=By.name("add-review");


    public void clickOnOrders()
    {
        Hooks.driver.findElement(Orders).click();
    }
    public void clickOnDetails()
    {
        Hooks.driver.findElement(details).click();
    }
    public void clickOnProd()
    {
        Hooks.driver.findElement(ProdDes).click();
    }
    public void clickOnAddReview(){
        Hooks.driver.findElement(Addreview).click();
        Hooks.driver.findElement(RevTitle).sendKeys(testData.reviewTitle);
        Hooks.driver.findElement(RevText).sendKeys(testData.reviewText);
        Hooks.driver.findElement(RevRate).click();
    }
    public void SubmitReview()
    {
        Hooks.driver.findElement(SubRev).click();
    }
}
