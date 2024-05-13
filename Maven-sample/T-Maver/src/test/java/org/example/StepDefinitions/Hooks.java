package org.example.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    //declare to the WebDriver object on the level of the class
   public static WebDriver driver;
    @Before
    public static void OpenBrowser()
    {
        //1- Create the Bridge

        String key = "webdriver.chrome.driver";
        String value ="/Volumes/EXTERNAL/Sprints course/Maven-sample/T-Maver/Browsers/chromedriver";
        System.setProperty("key","value");

        //2-Create a new object from webDriver
         driver = new ChromeDriver(); // The driver refers to the mouse and keyboard in automation testing.

        //3- Confriguration to the browser
        //3.1-maximuize the browser
        driver.manage().window().maximize();

        //3.2-set for the implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // allow the program to wait for a few seconds so that the browser can load the web page

        //4-navigate to the desired website
        String url = "https://demo.nopcommerce.com/";
        driver.navigate().to(url);


    }
    @After
    public static void CloseBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }

}
