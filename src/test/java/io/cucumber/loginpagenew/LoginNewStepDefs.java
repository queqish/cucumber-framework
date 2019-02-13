package io.cucumber.loginpagenew;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.cs.Ale;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginNewStepDefs {

    WebDriver driver;

    @Before()
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "/home/queqish/Desktop/ProjektOgorek/trening-z-ogorkiem/src/test/resources/chromedriver");
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
    @Given("^user navigates to \"([^\"]*)\"$")
    public void user_navigates_to(String url) throws Throwable {
        driver.get(url);  //http://www.webdriveruniversity.com/
    }

    @When("^user clicks on the login portal button$")
    public void user_clicks_on_the_login_portal_button() throws Throwable {
        driver.findElement(By.id("login-portal")).click();
    }

    @And("^user enters the \"([^\"]*)\" username$")
    public void user_enters_the_username(String username) throws Throwable {
        //tab code
        for (String windHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windHandle);
        }
        //send username keys
        driver.findElement(By.id("text")).sendKeys(username);

    }

    @And("^user enter the \"([^\"]*)\" password$")
    public void user_enter_the_password(String password) throws Throwable {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @When("^user clicks on the login button$")
    public void user_clicks_on_the_login_button() throws Throwable {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("^the user should be presented with the following prompt alert \"([^\"]*)\"$")
    public void the_user_should_be_presented_with_the_following_prompt_alert(String message) throws Throwable {
        Alert alert = driver.switchTo().alert(); //Alert
        Assert.assertEquals(alert.getText().toString().toLowerCase().replaceAll("\\s", ""), message.toLowerCase().replaceAll("\\s", ""));
        alert.accept();
    }

}
