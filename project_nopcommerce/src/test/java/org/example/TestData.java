package org.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import static org.example.stepDefs.Hooks.*;

public class TestData {
    public TestData() {
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader("src/test/resources/testData1.json")) {
            // Parse JSON file
            Object obj = parser.parse(reader);
             sourceJsonObject = (JSONObject) obj;

            // Extract data from JSON object
             fullName = (String) sourceJsonObject.get("FullName");
             firstName = (String) sourceJsonObject.get("FirstName");
             lastName = (String) sourceJsonObject.get("LastName");
             email = (String) sourceJsonObject.get("EmailAddress");
             password = (String) sourceJsonObject.get("Password");
             day = (String) sourceJsonObject.get("DD");
             month = (String) sourceJsonObject.get("MM");
             year = (String) sourceJsonObject.get("YY");
             product_url = (String) sourceJsonObject.get("Product_Url");
             countryValue = (String) sourceJsonObject.get("CountryValue");
             city = (String) sourceJsonObject.get("City");
             reviewText = (String) sourceJsonObject.get("ReviewText");
             reviewTitle = (String) sourceJsonObject.get("ReviewTitle");

            targetJsonObject.putAll(sourceJsonObject);

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public String fullName ;
    public String firstName ;
    public String lastName ;
    public String email ;
    public String password ;
    public String  day ;
    public String month;
    public String year;
    public String product_url;
    public String countryValue;
    public String city;
    public String reviewTitle;
    public String reviewText;
}
