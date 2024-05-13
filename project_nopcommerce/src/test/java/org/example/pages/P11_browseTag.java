package org.example.pages;
import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;

public class P11_browseTag {
    By clickComputer = By.xpath("//a[@href=\"/computers\"]");
    By clickViewAll = By.xpath("//a[@href=\"/producttag/all\"]");
    By PageTitle = By.tagName("h1");
    By ChooseTag = By.xpath("//a[@href=\"/shoes-2\"]");

    public void ClickComputer(){
        Hooks.driver.findElement(clickComputer).click();
    }
    public void clickViewAll(){
        Hooks.driver.findElement(clickViewAll).click();
    }
    public String  PageTitle(){
       return Hooks.driver.findElement(PageTitle).getText();
    }
    public void ChooseTag(){
        Hooks.driver.findElements(ChooseTag).get(1).click();
    }
}
