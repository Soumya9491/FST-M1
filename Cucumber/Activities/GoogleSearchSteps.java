package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchSteps {
WebDriver d;
WebDriverWait wait;
    @Given("^User is on Google Home Page$")
    public void Initialize() {
        d = new FirefoxDriver();
        d.get("https://google.com");
        wait = new WebDriverWait(d, 10);
    }

    @When("^User types in Cheese and hits ENTER$")
    public void search() {
        d.findElement(By.name("q")).sendKeys("Cheese");
        d.findElement(By.name("q")).sendKeys(Keys.ENTER);
    }

    @Then("^Show how many search results were shown$")
    public void searchResults() {
        wait.until(ExpectedConditions.visibilityOf(d.findElement(By.xpath("//div[@id='result-stats']"))));
        System.out.println(d.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }

    @And("^Close the browser$")
    public void close() {
        d.close();
    }
}
