package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity4 {
    AndroidDriver<MobileElement> ad;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc =new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 4 API 28");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.android.contacts");
        dc.setCapability("appActivity", ".activities.PeopleActivity");
        dc.setCapability("noReset", true);

        URL appserver = new URL("http://127.0.0.1:4723/wd/hub");
        ad = new AndroidDriver<MobileElement>(appserver, dc);
        wait = new WebDriverWait(ad, 10);
    }

    @Test
    public void addNewContact(){
        wait.until(ExpectedConditions.visibilityOf(ad.findElementByAccessibilityId("Create new contact")));
        ad.findElementByAccessibilityId("Create new contact").click();
        ad.findElementByXPath("android.widget.EditText[@text='First name']").sendKeys("Aaditya");
        ad.findElementByXPath("android.widget.EditText[@text='Last name']").sendKeys("Varma");
        ad.findElementByXPath("android.widget.EditText[@text='Phone']").sendKeys("9991284782");
        ad.findElementByXPath("android.widget.EditText[@text='SAVE']").click();
        Assert.assertEquals(ad.findElementById("title_gradient").getText(), "Aditya Varma");

    }

    @AfterClass
    public void close(){
        ad.close();
    }
}
