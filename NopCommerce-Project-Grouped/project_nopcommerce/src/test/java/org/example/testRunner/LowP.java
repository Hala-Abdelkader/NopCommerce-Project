package org.example.testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features =  "src/main/resources/features",
                glue = "org.example.stepDefs",
                tags = "@userStory10",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "junit:target/cukes.xml",
                        "rerun:target/rerun.txt"
                }

        )
public class LowP extends AbstractTestNGCucumberTests {
}
