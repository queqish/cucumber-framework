package io.cucumber.loginpage;

import cucumber.api.java.Before;
import cucumber.api.java.cs.Ale;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class LoginStepDefs {

    private WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.gecko.driver",
                "/home/odnowa/IdeaProjects/cucumber-framework/src/test/resources/geckodriver");
        this.driver = new FirefoxDriver();
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }

    @Given("^A User navigates to webdriveruniversity website$")
    public void user_navigates_to_webdriveruniversity_website() throws Throwable {
        driver.get("http://webdriveruniversity.com/Login-Portal/index.html");
    }

//    @Given("^A User clicks on the login button on homepage$")
//    public void user_clicks_on_the_login_button_on_homepage() throws Throwable {
//        driver.findElement(By.xpath("//a[contains(text(), 'Log In')]")).click();
//    }

    @And("^User enters a \"([^\"]*)\" username$")
    public void userEntersAUsername(String username) throws Throwable {
        driver.findElement(By.xpath(".//*[@id='text']")).sendKeys(username);
    }

    @And("^User enters a \"([^\"]*)\" password$")
    public void userEntersAPassword(String password) throws Throwable {
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(password);
    }

    @When("^A User clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        driver.findElement(By.xpath(".//*[@id='login-button']")).click();
    }

    @Then("^A User should be taken to the successful login page$")
    public void aUserShouldBeTakenToTheSuccessfulLoginPage() throws InterruptedException {

        Thread.sleep(1000); 
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "validation succeeded");
        Thread.sleep(5000);
        alert.accept();
        Thread.sleep(5000);

    }

    @Then("^A User should be taken to the unsuccessful login page$")
    public void aUserShouldBeTakenToTheUnsuccessfulLoginPage() throws InterruptedException {

        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "validation failed");
        Thread.sleep(5000);
        alert.accept();
        Thread.sleep(5000);

    }



}
