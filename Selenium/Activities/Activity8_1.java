package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/tables");
        System.out.println("No of Rows: " +driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr")).size());
        System.out.println("No of Columns: "+driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td")).size());
        List<WebElement> e = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));
        for(WebElement x : e)
        {
            System.out.println(x.getText());
        }
        System.out.println(driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody/tr[2]/td[2]")).getText());
        driver.close();
    }
}
