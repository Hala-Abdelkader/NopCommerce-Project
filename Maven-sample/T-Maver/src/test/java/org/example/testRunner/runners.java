package org.example.testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features",
        glue = "org.example.StepDefinitions",
        tags = "@Test",
        plugin = {
                "pretty",
                "html:target/cucmber.html",
                 "json:target/cucumber.json",
                "junit:target/cukes.xml",
                "rerun:target/rerun.txt"
        }
)

public class runners extends AbstractTestNGCucumberTests {

}


