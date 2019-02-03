package io.cucumber.skeleton;

import com.cucumber.listener.ExtentCucumberFormatter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/io/cucumber/skeleton",
        glue = "io.cucumber.skeleton",
        tags={},
        monochrome = true
)

public class RunCucumberTest {
        public static void main(String[] args) {
                System.out.println("something");
        }
}
