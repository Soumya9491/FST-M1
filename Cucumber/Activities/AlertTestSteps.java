package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertTestSteps {
    WebDriver d;
    WebDriverWait wait;
    Alert a;

    @Given("^User is on the page$")
    public void setup() {
        d = new FirefoxDriver();
        wait = new WebDriverWait(d, Duration.ofSeconds(10));
        d.get("https://www.training-support.net/selenium/javascript-alerts");
    }

    @When("^User clicks the Simple Alert button$")
    public void simpleAlert() {
        d.findElement(By.xpath("//button[@id='simple']")).click();
    }

    @When("^User clicks the Confirm Alert button$")
    public void confirmAlert() {
        d.findElement(By.xpath("//button[@id='confirm']")).click();
    }

    @When("^User clicks the Prompt Alert button$")
    public void promptAlert() {
        d.findElement(By.xpath("//button[@id='prompt']")).click();
    }

    @Then("^Alert opens$")
    public void switchAlert() {
        a = d.switchTo().alert();
    }

    @And("^Read the text from it and print it$")
    public void verifyText() {
        System.out.println(a.getText());
    }

    @And("^Write a custom message in it$")
    public void write() {
        a.sendKeys("Custom Message");
    }

    @And("^Close the alert$")
    public void closeAlert() {
        a.accept();
    }

    @And("^Close the alert with Cancel$")
    public void closeAlertCancel() {
        a.dismiss();
    }

    @And("^Close Browser$")
    public void close() {
        d.close();
    }
}
