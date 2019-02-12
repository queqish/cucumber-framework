package io.cucumber.loginpage;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
        "html:target/cucumber",
        "json:target/cucumber.json",
        "com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
        },
        features = "src/test/resources/io/cucumber/loginpage",
        glue = "io.cucumber.loginpage",
        tags={},
        monochrome = true
)

public class RunLoginPageTest {
//        public static void main(String[] args) {
//                System.out.println("something");
//        }
}
