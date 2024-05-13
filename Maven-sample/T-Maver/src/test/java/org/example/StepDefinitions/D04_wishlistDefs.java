package org.example.StepDefinitions;

import io.cucumber.java.en.*;
import org.example.pages.P03_addtoWishlist;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class D04_wishlistDefs {
   P03_addtoWishlist wishList = new P03_addtoWishlist();


      @Given ("User browse for an item")
    public void browseItem(){
         wishList.clickBook();
      }

      @And("User add the item to my wishlist")
          public void addtoWishlist() throws InterruptedException {
            wishList.cllickAddbook();
            System.out.println("Item added successfully");
          }

       @And ("User browse for another item")
         public void browseanotherItem(){
            wishList.clickDigital();
            wishList.clickAddDigital();
          System.out.println("Item added successfully");
        }
    @Then("User should see the items in the wishlist")
    public void checkWishlisht(){
        wishList.gotoWishlist();
      }
    @And ("User change the Qty of the second item")
         public void changeQty(){
        WebElement currentQty = wishList.itemQty();
        currentQty.clear();
        currentQty.sendKeys("3");

       }
    @And ("user the click update wishlist")
   public void updatewishList(){
       wishList.clickUpdateList();
    }

   @Then ("The user should see the new qty and price")
    public void checkQty(){

       SoftAssert soft = new SoftAssert();

       String actualnewQty = wishList.itemQty().getAttribute("value");
       String expectednewQty = "3";

       soft.assertEquals(actualnewQty,expectednewQty,"Qty assert Failed");
       soft.assertAll();
      System.out.println("Qty changed successfully");
   }
}
