package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println(driver.getTitle());
        Actions a = new Actions(driver);
        a.sendKeys("S").build().perform();
        System.out.println(driver.findElement(By.id("keyPressed")).getText());

        a.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        System.out.println(driver.findElement(By.id("keyPressed")).getText());
        driver.close();
    }
}
