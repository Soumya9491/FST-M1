package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//input[contains(@class,'-username')]")).sendKeys("Test");
        driver.findElement(By.xpath("//input[contains(@class,'-password')]")).sendKeys("Test123");
        driver.findElement(By.xpath("//label[text()='Confirm Password']/..//input")).sendKeys("Test123");
        driver.findElement(By.xpath("//input[contains(@class,'email')]")).sendKeys("test@qwe.com");
        driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='action-confirmation']"))));
        System.out.println(driver.findElement(By.xpath("//div[@id='action-confirmation']")).getText());
        driver.close();
    }
}
