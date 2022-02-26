package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement e = driver.findElement(By.xpath("//input[@id='input-text']"));
        if(e.isEnabled())
        {
            System.out.println("Checkbox is enabled");
        }
        else
        {
            System.out.println("Checkbox is not enabled");
        }
        driver.findElement(By.xpath("//button[text()='Enable Input']")).click();
        if(e.isEnabled())
        {
            System.out.println("Checkbox is enabled");
        }
        else
        {
            System.out.println("Checkbox is not enabled");
        }
        driver.close();
    }
}
