package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());
        Actions a = new Actions(driver);
        a.click(driver.findElement(By.xpath("//div[@id='side3']"))).build().perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='side3']/h1")).getText());
        a.doubleClick(driver.findElement(By.xpath("//div[@id='side3']"))).build().perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='side3']/h1")).getText());
        a.contextClick(driver.findElement(By.xpath("//div[@id='side3']"))).build().perform();
        System.out.println(driver.findElement(By.xpath("//div[@id='side3']/h1")).getText());
        driver.close();
    }
}
