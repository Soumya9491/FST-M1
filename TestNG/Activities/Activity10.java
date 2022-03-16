package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity10 {
    WebDriver d;
    @BeforeClass
    public void setUp()
    {
        d = new FirefoxDriver();

        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        d.get("https://www.training-support.net/selenium/sliders");

    }

    @Test
    public void verifyMiddleValue(){
        WebElement slider = d.findElement(By.id("slider"));
        slider.click();

        String percent = d.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("Middle value: " + percent);

        Assert.assertEquals(percent, "50");
    }

    @Test
    public void verifyMaximumValue(){
        WebElement slider = d.findElement(By.id("slider"));
        Actions a = new Actions(d);
        a.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();

        String percent = d.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("Max value: " + percent);

        Assert.assertEquals(percent, "100");
    }

    @Test
    public void verifyMinValue(){
        WebElement slider = d.findElement(By.id("slider"));
        Actions a = new Actions(d);
        a.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();

        String percent = d.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("Min value: " + percent);

        Assert.assertEquals(percent, "0");
    }

    @Test
    public void verifyThirtyPercentValue(){
        WebElement slider = d.findElement(By.id("slider"));
        Actions a = new Actions(d);
        a.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();

        String percent = d.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("value: " + percent);

        Assert.assertEquals(percent, "30");
    }

    @Test
    public void verifyEightyPercentValue(){
        WebElement slider = d.findElement(By.id("slider"));
        Actions a = new Actions(d);
        a.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();

        String percent = d.findElement(By.xpath("//span[@id='value']")).getText();
        Reporter.log("value: " + percent);

        Assert.assertEquals(percent, "80");
    }

    @AfterClass
    public void close(){
        d.close();
    }

}
