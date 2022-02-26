package activities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity7 {
    WebDriver d;

    @BeforeClass
    public void setUp()
    {
        d = new FirefoxDriver();

        d.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

        d.get("https://www.training-support.net/selenium/login-form");

    }

    @DataProvider(name="Authentication")
    public static Object[][] cred(){
        return new Object[][]{{"admin","password"}};
    }

    @Test


}
