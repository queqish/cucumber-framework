package io.cucumber.contactus;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ContactUsStepDefs {

    WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/home/odnowa/IdeaProjects/cucumber-framework/src/test/resources/chromedriver");
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }


    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Given("^I access webdriveruniversity$")
    public void iAccessWebdriveruniversity() throws InterruptedException {
        Thread.sleep(1000);
        driver.get("http://www.webdriveruniversity.com");
    }

    @When("^I click on the contact us button$")
    public void iClickOnTheContactUsButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("contact-us")).click();
    }

    @And("^I enter a valid first name$")
    public void iEnterAValidFirstName() {
        // Store the current window handle
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        driver.findElement(By.cssSelector("input[name='first_name']")).sendKeys("Pablo");

    }


    @When("^I enter a valid last name$")
    public void i_enter_a_valid_last_name(DataTable arg1) throws Throwable {
        List<List<String>> data = arg1.raw();
        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys(data.get(0).get(0));
    }

//    @And("^I enter a valid last name$")
//    public void iEnterAValidLastName() {
//
//        driver.findElement(By.cssSelector("input[name='last_name']")).sendKeys("Pavo");
//
//    }

    @And("^I enter a valid email address$")
    public void iEnterAValidEmailAddress() {

        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("pablo@pavo.com");
    }

    @When("^I enter comments$")
    public void i_enter_comments(DataTable arg1) throws Throwable {
        List<List<String>> data = arg1.raw();
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys(data.get(0).get(1));
    }

    @When("^I click on the submit button$")
    public void iClickOnTheSubmitButton () {
        driver.findElement(By.cssSelector("input[value='SUBMIT']"));
    }

    @Then("^the information should successfully be submitted via the contact us form$")
    public void theInformationShouldSuccessfullyBeSubmittedViaTheContactUsForm () {

    }
}
