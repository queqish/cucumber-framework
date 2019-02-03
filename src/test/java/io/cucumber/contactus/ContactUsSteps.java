package io.cucumber.contactus;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ContactUsSteps {

    WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.gecko.driver",
                "/home/queqish/Desktop/ProjektOgorek/trening-z-ogorkiem/src/test/resources/geckodriver");
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }


    @And("^User enters first name$")
    public void userEntersFirstName() {
        driver.get("http://webdriveruniversity.com/Contact-Us/contactus.html");
    }

    @And("^User enters last name$")
    public void userEntersLastName() {
        driver.findElement(By.tagName("first_name")).sendKeys("Pablo");
    }

    @And("^User enters Comment$")
    public void userEntersComment() {
        driver.findElement(By.tagName("last_name")).sendKeys("Pavo");
    }

    @Given("^User enters \"([^\"]*)\" email address$")
    public void userEntersEmailAddress(String emailAddress) throws Throwable {
        driver.findElement(By.tagName("email")).sendKeys(emailAddress);
        throw new PendingException();
    }

    @When("^User clicks submit button$")
    public void userClicksSubmitButton() {
        driver.findElement(By.linkText("SUBMIT")).click();
    }

    @Then("^User should see correct message$")
    public void userShouldSeeCorrectMessage() {
    }

    @Then("^User should see error message$")
    public void userShouldSeeErrorMessage() {

    }

    @When("^User clicks reset button$")
    public void userClicksResetButton() {
        driver.findElement(By.linkText("RESET")).click();
    }

    @Then("^All textboxes should be empty$")
    public void allTextboxesShouldBeEmpty() {
        WebElement webElement;
    }
}
