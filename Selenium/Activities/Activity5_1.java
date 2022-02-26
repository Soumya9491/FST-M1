package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement ele = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        if(ele.isDisplayed())
        {
            System.out.println("Checkbox is displayed");
        }
        else{
            System.out.println("Checkbox is not displayed");
        }
        driver.findElement(By.xpath("//button[@id='toggleCheckbox']")).click();
        if(ele.isDisplayed())
        {
            System.out.println("Checkbox is displayed");
        }
        else{
            System.out.println("Checkbox is not displayed");
        }
        driver.close();
    }
}
