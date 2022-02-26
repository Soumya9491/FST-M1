package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/selects");
        WebElement e = driver.findElement(By.id("multi-select"));
        Select s = new Select(e);
        if(s.isMultiple())
        {
            s.selectByVisibleText("Javascript");
            s.selectByValue("node");
            for(int i =4; i< 7; i++)
            {
                s.selectByIndex(i);
            }
            s.deselectByValue("node");
            s.deselectByIndex(7);
            List<WebElement> ele = s.getAllSelectedOptions();
            for(WebElement x : ele)
            {
                System.out.println(x.getText());
            }

            s.deselectAll();
        }
        driver.close();
    }
}
