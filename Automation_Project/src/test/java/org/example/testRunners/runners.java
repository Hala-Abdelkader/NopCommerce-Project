package org.example.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                features ="src/main/resources/features",
                glue = "org.example.stepDefs",
                plugin = {
                        "pretty",
                        "html:target/cucumber.html",
                        "rerun:target/rerun.txt"
                }
        )

public class runners extends AbstractTestNGCucumberTests
{


}
