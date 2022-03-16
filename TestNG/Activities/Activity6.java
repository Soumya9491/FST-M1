package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Activity6 {
    WebDriver driver;
    @BeforeClass
    public void beforeMethod() {
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }

    @Test
    @Parameters({"Username", "Password"})
    public void login(String Username, String Password)
    {
        driver.findElement(By.id("username")).sendKeys(Username);
        driver.findElement(By.id("password")).sendKeys(Password);
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
    }

    @AfterClass
    public void close(){
        driver.close();
    }
}
