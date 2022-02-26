package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.get("https://training-support.net");
    }

    @Test
    public void verifyAboutUs()
    {
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Training Support");
        driver.findElement(By.id("about-link")).click();
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "About Us");
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
