package io.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"},
        features = {"src/test/resources/io/cucumber/loginpage","src/test/resources/io/cucumber/contactus"},
        glue = {"io.cucumber.loginpage","io.cucumber.contactus"},
        tags={},
        monochrome = true
)

public class RunTests {
        public static void main(String[] args) {
                System.out.println("something");
        }
}
//run many tests