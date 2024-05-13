package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class P10_addtoWishlist {

    By clickBookCategorybtn = By.xpath("//a[@href=\"/books\"]");
    By clickAddBook = By.xpath("//button[@title=\"Add to wishlist\"]"); //get(2)
    By browsefordigitalDownload = By.xpath("//a[@href=\"/digital-downloads\"]");
    By clickAdddigital = By.xpath("//button[@title=\"Add to wishlist\"]"); //get(2)
    By clickwishlist = By.className("ico-wishlist");
    By itemQty = By.className("qty-input");
    By updateList = By.id("updatecart");

    public void clickBook(){
        Hooks.driver.findElement(clickBookCategorybtn).click();
    }
    public void cllickAddbook(){
        Hooks.driver.findElements(clickAddBook).get(1).click();
    }
    public void clickDigital(){
        Hooks.driver.findElement(browsefordigitalDownload).click();
    }
    public void clickAddDigital(){
        Hooks.driver.findElements(clickAdddigital).get(1).click();
    }
    public void gotoWishlist(){
        Hooks.driver.findElement(clickwishlist).click();
    }
    public WebElement itemQty(){
        return Hooks.driver.findElements(itemQty).get(1);

    }
    public void clickUpdateList(){
        Hooks.driver.findElement(updateList).click();
    }
}
