package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {
    WebDriver d;
    @BeforeClass
    public void setUp()
    {
        d = new FirefoxDriver();

        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get("https://www.training-support.net/selenium/javascript-alerts");

    }

    @Test
    public void simpleAlertTestCase(){
        Reporter.log("SimpleAlert");
        d.findElement(By.xpath("//button[text()='Simple Alert']")).click();
        Reporter.log("Alert opened");
        Alert a = d.switchTo().alert();
        Assert.assertEquals("This is a JavaScript Alert!", a.getText());
        Reporter.log(a.getText());
        a.accept();
    }

    @Test
    public void confirmAlertTestCase(){
        Reporter.log("ConfirmAlert");
        d.findElement(By.xpath("//button[text()='Confirmation']")).click();
        Reporter.log("Alert Opened");
        Alert a = d.switchTo().alert();
        Assert.assertEquals("This is a JavaScript Confirmation!", a.getText());
        Reporter.log(a.getText());
    }

    @Test
    public void promptAlertTestCase(){
        Reporter.log("PromptAlert");
        d.findElement(By.xpath("//button[text()='Prompt']")).click();
        Reporter.log("Alert Opened");
        Alert a = d.switchTo().alert();
        Assert.assertEquals("This is a JavaScript Prompt!", a.getText());
        Reporter.log(a.getText());
        a.sendKeys("Hi");
        a.accept();
    }

    @AfterClass
    public void close(){
        d.close();
    }
}
