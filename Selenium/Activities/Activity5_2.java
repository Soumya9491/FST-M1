package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        System.out.println(driver.getTitle());
        WebElement ele = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        boolean flag = ele.isSelected();
        if(flag)
        {
            System.out.println("Checkbox is checked");
        }
        else
        {
            System.out.println("Checkbox is not checked");
        }
        ele.click();
        if(ele.isSelected())
        {
            System.out.println("Checkbox is checked");
        }
        else
        {
            System.out.println("Checkbox is not checked");
        }

        driver.close();
    }
}
