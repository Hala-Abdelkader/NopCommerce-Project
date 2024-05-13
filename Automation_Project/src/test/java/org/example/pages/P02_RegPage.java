package org.example.pages;

import com.github.javafaker.Faker;
import org.example.stepDefs.Hooks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import java.io.FileReader;
import java.io.FileWriter;


public class P02_RegPage
{

public static String getEmailAddress() {
 // Create Faker instance
 Faker faker = new Faker();

 // Generate fake email address
 String emailAddress = faker.internet().emailAddress();

 // Create JSON object
 JSONObject jsonObject = new JSONObject();
 jsonObject.put("EmailAddress", emailAddress);

 // Write JSON object to file
 try (FileWriter file = new FileWriter("src/test/resources/testData1.json")) {
  file.write(jsonObject.toJSONString());
  file.flush();
  System.out.println("Fake email generated and written to testdata.json");
 } catch (Exception e) {
  e.printStackTrace();
 }

 // Return the generated email address
 return emailAddress;
}

 public static String getfirstname() {
  JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
   JSONObject jsonObject = (JSONObject) obj;
   return (String) jsonObject.get("FirstName");
  } catch (Exception e) {
   e.printStackTrace();
   return null; // Return null or handle the error appropriately
  }
 }

 public static String getlastname() {
  JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
   JSONObject jsonObject = (JSONObject) obj;
   return (String) jsonObject.get("LastName");
  } catch (Exception e) {
   e.printStackTrace();
   return null; // Return null or handle the error appropriately
  }
 }


 public static String getpassword() {
  JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
   JSONObject jsonObject = (JSONObject) obj;
   return (String) jsonObject.get("Password");
  } catch (Exception e) {
   e.printStackTrace();
   return null; // Return null or handle the error appropriately
  }
 }

 public static String getBirthDay() {
  JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
   JSONObject jsonObject = (JSONObject) obj;
   return (String) jsonObject.get("BirthDay");
  } catch (Exception e) {
   e.printStackTrace();
   return null; // Return null or handle the error appropriately
  }
 }


 public static String getBirthMonth() {
  JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
   JSONObject jsonObject = (JSONObject) obj;
   return (String) jsonObject.get("BirthMonth");
  } catch (Exception e) {
   e.printStackTrace();
   return null; // Return null or handle the error appropriately
  }
 }

 public static String getBirthYear() {
  JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader("src/test/resources/testData.json"));
   JSONObject jsonObject = (JSONObject) obj;
   return (String) jsonObject.get("BirthYear");
  } catch (Exception e) {
   e.printStackTrace();
   return null; // Return null or handle the error appropriately
  }
 }


 By registerIcon = By.className("ico-register");
 By genderMale = By.id("gender-male");
 By genderFemale  = By.id("gender-female");
 By firstName  = By.id("FirstName");
 By lastName  = By.id("LastName");
 By day  = By.name("DateOfBirthDay");
 By month  = By.name("DateOfBirthMonth");
 By year  = By.name("DateOfBirthYear");
 By email  = By.id("Email");
 By password  = By.id("Password");
 By confirmPassword  = By.id("ConfirmPassword");
 By registerBtn  = By.id("register-button");
 By successMsg  = By.className("result");


    public void clickMale()
 {
  Hooks.driver.findElement(genderMale).click();
 }
 public void clickFemale()
 {
  Hooks.driver.findElement(genderFemale).click();
 }
 public void clickRegister()
 {
  Hooks.driver.findElement(registerIcon).click();
 }

 public void setFirstNameandLastName()
 {
  Hooks.driver.findElement(firstName).sendKeys(getfirstname());
  Hooks.driver.findElement(lastName).sendKeys(getlastname());
 }

 public void setDateofBirth()
 {
  WebElement Day = Hooks.driver.findElement(day);
  Select selectDay =new Select(Day);
  selectDay.selectByValue(getBirthDay());

  WebElement Month = Hooks.driver.findElement(month);
  Select selectMonth=new Select(Month);
  selectMonth.selectByValue(getBirthMonth());

  WebElement Year = Hooks.driver.findElement(year);
  Select selectYear= new Select(Year);
  selectYear.selectByValue(getBirthYear());
 }

 public void setEmail()
 {
  WebElement Email = Hooks.driver.findElement(email);
  Email.sendKeys(getEmailAddress());
 }

 public void setPasswordandConfirm()
 {
  Hooks.driver.findElement(password).sendKeys(getpassword());
  Hooks.driver.findElement(confirmPassword).sendKeys(getpassword());
 }


 public void ClickRegBtn()
 {
  WebElement RegBtn = Hooks.driver.findElement(registerBtn);
  RegBtn.click();
 }

 public void SuccessMsg()
 {
  WebElement Msg = Hooks.driver.findElement(successMsg);
  SoftAssert soft= new SoftAssert();
  soft.assertTrue(Msg.getText().contains("Your registration completed"));
  String actualColor= Msg.getCssValue("color");
  soft.assertEquals(Color.fromString(actualColor).asHex(),"#4cb17c");
  soft.assertAll();
 }

}
