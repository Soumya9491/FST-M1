package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println(driver.getTitle());
        System.out.println(driver.getWindowHandle());
        driver.findElement(By.id("launcher")).click();
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        w.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles = driver.getWindowHandles();
        for(String s : handles)
        {
            System.out.println(s);
            driver.switchTo().window(s);
        }
        System.out.println(driver.getTitle());
        System.out.println(driver.findElement(By.xpath("//div[@class='sub header']")));
        driver.findElement(By.id("actionButton")).click();
        w.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> handles1 = driver.getWindowHandles();
        for(String x : handles1)
        {
            System.out.println(x);
            driver.switchTo().window(x);
        }
        driver.quit();
    }
}
