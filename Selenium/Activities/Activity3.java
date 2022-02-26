package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println(driver.getTitle());
        driver.findElement(By.id("firstName")).sendKeys("Soumya");
        driver.findElement(By.id("lastName")).sendKeys("Tripathy");
        driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
        driver.findElement(By.id("number")).sendKeys("0987654321");
        driver.findElement(By.xpath("//input[@type='submit']"));
        driver.close();
    }
}
