package io.cucumber.products;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ProductsStepDefs {

    WebDriver driver;

    @Before()
    public void setup(){
        try {
            System.setProperty("webdriver.chrome.driver", Paths.get(System.getProperty("user.dir")).toRealPath() + "src/test/java/resources/chromedriver.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @Given("^user navigates to \"([^\"]*)\" website$")
    public void userNavigatesToWebsite(String url) throws Throwable {
        Thread.sleep(50);
        driver.get(url);
    }

    @When("^user clicks on \"([^\"]*)\"$")
    public void userClicksOn(String location) throws Throwable {
        driver.findElement(By.cssSelector(location)).click();
    }

    @Then("^user should be presented with a promo alert$")
    public void userShouldBePresentedWithAPromoAlert() {
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
    }
}
