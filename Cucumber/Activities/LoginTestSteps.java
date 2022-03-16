package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTestSteps {

    WebDriver d;
    WebDriverWait wait;

    @Given("^User is on Login page$")
    public void setup() {
        d = new FirefoxDriver();
        wait = new WebDriverWait(d, Duration.ofSeconds(10));
        d.get("https://www.training-support.net/selenium/login-form");
    }

    @When("^User enters username and password$")
    public void login() {
        d.findElement(By.id("username")).sendKeys("admin");
        d.findElement(By.id("password")).sendKeys("password");
        d.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @When("^User enters \"(.*)\" and \"(.*)\"$")
    public void loginnew(String username, String password) throws Throwable {
        d.findElement(By.id("username")).sendKeys(username);
        d.findElement(By.id("password")).sendKeys(password);
        d.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("^Read the page title and confirmation message$")
    public void verify() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        System.out.println(d.getTitle());
        System.out.println(d.findElement(By.id("action-confirmation")).getText());
    }

    @Then("^Read the page title and confirmation message$")
    public void readTitleAndHeading() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        System.out.println(d.getTitle());
        System.out.println(d.findElement(By.id("action-confirmation")).getText());

        if(d.findElement(By.id("action-confirmation")).getText().contains("admin")) {
            Assert.assertEquals(d.findElement(By.id("action-confirmation")).getText(), "Welcome Back, admin");
        } else {
            Assert.assertEquals(d.findElement(By.id("action-confirmation")).getText(), "Invalid Credentials");
        }
    }

    @And("^Close the Browser$")
    public void close() {
        d.close();
    }
}
