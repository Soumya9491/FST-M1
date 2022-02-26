package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String title = driver.getTitle();
        System.out.println(title);

        WebElement idElement = driver.findElement(By.id("about-link"));
        WebElement classElement = driver.findElement(By.xpath("//a[@class='ui inverted huge green button']"));
        WebElement lnkElement = driver.findElement(By.linkText("About Us"));
        WebElement cssElement = driver.findElement(By.cssSelector("a#about-link"));

        System.out.println(idElement.getText());
        driver.close();
    }
}
