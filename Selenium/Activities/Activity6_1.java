package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement btn = driver.findElement(By.id("toggleCheckbox"));
        WebElement ele = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        btn.click();
        w.until(ExpectedConditions.invisibilityOf(ele));
        btn.click();
        w.until(ExpectedConditions.visibilityOf(ele));
        driver.close();
    }
}
