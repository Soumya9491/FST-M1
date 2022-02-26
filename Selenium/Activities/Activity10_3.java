package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println(driver.getTitle());
        WebElement ball = driver.findElement(By.xpath("//img[@id='draggable']"));
        WebElement dropzone1 = driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement dropzone2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));
        Actions a = new Actions(driver);
        a.dragAndDrop(ball, dropzone1).build().perform();
        if (driver.findElement(By.xpath("//div[@id='droppable']/p")).getText().equals("Dropped!"))
        {
            System.out.println("Drag and drop is done");
        }
        else
        {
            System.out.println("Drag and drop is not done");
        }
        a.dragAndDrop(dropzone1,dropzone2).build().perform();
        if (driver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText().equals("Dropped!"))
        {
            System.out.println("Drag and drop is done");
        }
        else
        {
            System.out.println("Drag and drop is not done");
        }

        driver.close();
    }
}
