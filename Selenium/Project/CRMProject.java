package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CRMProject {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setup()
    {
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://alchemy.hguy.co/crm/");
    }

    @Test
    public void verifyWebSiteTitle()
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='SuiteCRM']"))));
        String title = driver.getTitle();
        Assert.assertEquals(title, "SuiteCRM");
        System.out.println("Title is matching");
    }

    @Test
    public void getUrlOfHeader()
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@alt='SuiteCRM']"))));
        String url = driver.findElement(By.xpath("//img[@alt='SuiteCRM']")).getAttribute("src");
        System.out.println("URL of the header image : " + url);
    }

    @Test
    public void getCopyrightText()
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='p_login_bottom']/a[1]"))));
        String copyRight = driver.findElement(By.xpath("//div[@class='p_login_bottom']/a[1]")).getText();
        System.out.println("First copyright text in the footer : " + copyRight);
    }

    @DataProvider(name = "credentials")
    public Object[][] getCredential() {
        return new Object [][] {{"admin","pa$$w0rd"}};
    }

    @Test(dataProvider = "credentials")
    public void loginToApplication(String username, String password)
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_name"))));
        driver.findElement(By.id("user_name")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_password"))));
        driver.findElement(By.id("username_password")).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Login"))));
        driver.findElement(By.name("Login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='admin']/.."))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='admin']/..")).isDisplayed());

    }

    @Test(dataProvider = "credentials")
    public void getColors(String username, String password)
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_name"))));
        driver.findElement(By.id("user_name")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_password"))));
        driver.findElement(By.id("username_password")).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Login"))));
        driver.findElement(By.name("Login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='admin']/.."))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='admin']/..")).isDisplayed());
        String color = driver.findElement(By.id("toolbar")).getCssValue("color");
        System.out.println("Color of the navigation menu is : " + color);
    }

    @Test(dataProvider = "credentials")
    public void verifyActivitiesLink(String username, String password)
    {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_name"))));
        driver.findElement(By.id("user_name")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_password"))));
        driver.findElement(By.id("username_password")).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Login"))));
        driver.findElement(By.name("Login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='admin']/.."))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='admin']/..")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Activities']"))));
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Activities']")).isDisplayed() && driver.findElement(By.xpath("//a[text()='Activities']")).isEnabled());
        System.out.println("Activities link is displayed");
    }

    @Test(dataProvider = "credentials")
    public void readAdditionalInfo(String username, String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_name"))));
        driver.findElement(By.id("user_name")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_password"))));
        driver.findElement(By.id("username_password")).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Login"))));
        driver.findElement(By.name("Login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='admin']/.."))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='admin']/..")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Sales']"))));
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).click(driver.findElement(By.xpath("//a[text()='Leads']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Leads')]"))));
        if(driver.findElements(By.xpath("//span[@title='Additional Details']")).size()>0)
        {
            driver.findElements(By.xpath("//span[@title='Additional Details']")).get(0).click();
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='phone']"))));
            String phone = driver.findElement(By.xpath("//span[@class='phone']")).getText();
            System.out.println("Phone number : " + phone);
        }

    }

    @Test(dataProvider = "credentials")
    public void printAccountsTable(String username, String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_name"))));
        driver.findElement(By.id("user_name")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_password"))));
        driver.findElement(By.id("username_password")).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Login"))));
        driver.findElement(By.name("Login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='admin']/.."))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='admin']/..")).isDisplayed());
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Sales']"))));
        Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).click(driver.findElement(By.xpath("//a[text()='Accounts']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Accounts')]"))));
        if(driver.findElements(By.xpath("//td[@field='name']//a")).size()>0)
        {
            int temp = 0;
            for(WebElement ele : driver.findElements(By.xpath("//td[@field='name']//a")))
            {
                int count = 0;
                    if(temp%2 == 0)
                    {
                        System.out.println("Elements at odd positions are : " + ele.getText());
                    }
                    count++;
                    if(count==5)
                    {
                        break;
                    }
                    temp = temp+1;
                }
            }
        }



    @Test(dataProvider = "credentials")
    public void printUsernamesAndFullNames(String username, String password) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("user_name"))));
        driver.findElement(By.id("user_name")).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_password"))));
        driver.findElement(By.id("username_password")).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("Login"))));
        driver.findElement(By.name("Login")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='admin']/.."))));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='admin']/..")).isDisplayed());

        Actions a = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Sales']"))));
        a.moveToElement(driver.findElement(By.xpath("//a[text()='Sales']"))).click(driver.findElement(By.xpath("//a[text()='Leads']"))).build().perform();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),'Leads')]"))));
        for(int i = 0; i<=10; i++)
        {
            String name = driver.findElements(By.xpath("//td[@field='name']//a")).get(i).getText();
            String user = driver.findElements(By.xpath("//td[@field='assigned_user_name']//a")).get(i).getText();
            System.out.println("Name is : "+ name + "& User is : "+ user);
        }
    }
    @AfterMethod
    public void close()
    {
        driver.close();
    }
}
