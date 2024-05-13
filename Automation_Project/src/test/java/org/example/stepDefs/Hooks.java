package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;


public class Hooks {

    public static WebDriver driver;
    @Before
    public static void OpenBrowser()
    {
        //Create new object from WebDriver
        driver = new ChromeDriver();

        //maximize browser
        driver.manage().window().maximize();

        //Wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Navigate to the website URL
        String url = "https://demo.nopcommerce.com/";
        driver.navigate().to(url);
    }


    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        //Close the browser
        driver.quit();
    }
}
