package org.example.stepDefs;

import io.cucumber.java.en.Given;
import org.example.pages.P00_Homepage;
import org.example.pages.P03_Login;

import static org.example.stepDefs.Hooks.testData;

public class D03_LoginDef {

        P00_Homepage homepage = new P00_Homepage();
        P03_Login login = new P03_Login();



    @Given("User LogIn Valid")
    public void userLogInValid() {
        homepage.gotoLogin();
        login.sendEmail(testData.email);
        login.sendPassword(testData.password);
        login.clickLogin();
    }


}
