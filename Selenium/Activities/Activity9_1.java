package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        WebElement drpdwn = driver.findElement(By.xpath("//select[@id='single-select']"));
        Select s = new Select(drpdwn);
        s.selectByVisibleText("Option 2");
        s.selectByIndex(3);
        s.selectByValue("4");
        List<WebElement> e = s.getAllSelectedOptions();
        for(WebElement x : e)
        {
            System.out.println(x.getText());
        }
        driver.close();
    }
}
