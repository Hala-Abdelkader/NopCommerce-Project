package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.TestData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    public static TestData testData;
    public static JSONObject sourceJsonObject;
    public static JSONObject targetJsonObject;
    public static boolean jsonFlag;

    @Before
    public static void openBrowser(){
        driver = new ChromeDriver();
        sourceJsonObject = new JSONObject();
        targetJsonObject = new JSONObject();
        testData = new TestData();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
    }


    @After
    public static void quitBrowser() throws InterruptedException {
        if(jsonFlag) {
            try (FileWriter file = new FileWriter("src/test/resources/testData1.json")) {

                file.write(targetJsonObject.toJSONString());
                file.flush();
                System.out.println("Test Data generated and written to testdata.json");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        jsonFlag=false;
        Thread.sleep(1500);
        driver.quit();
    }
}
