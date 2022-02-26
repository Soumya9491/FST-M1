package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @Test
    public void verifyTitle()
    {
        Assert.assertEquals(driver.getTitle(), "Target Practice");
    }

    @Test
    public void testCase2() {
        WebElement ele = driver.findElement(By.xpath("//button[text()='Black']"));
        Assert.assertTrue(ele.isDisplayed());
        Assert.assertEquals(ele.getText(), "black");
    }

    @Test(enabled = false)
    public void testCase3() {
    }

    @Test
    public void testCase4() {
        throw new SkipException("Skipping test case");
    }

    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
