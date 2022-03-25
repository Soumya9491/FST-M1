package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity2 {

    AndroidDriver<MobileElement> ad;
    WebDriverWait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc =new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 4 API 28");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.android.chrome");
        dc.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        dc.setCapability("noReset", true);

        URL appserver = new URL("http://127.0.0.1:4723/wd/hub");
        ad = new AndroidDriver<MobileElement>(appserver, dc);
        wait = new WebDriverWait(ad, 10);
    }

    @Test
    public void calculator(){
        ad.get("https://www.training-support.net/");
        wait.until(ExpectedConditions.visibilityOf(ad.findElementByXPath("//android.view.View[@text='Training Support']")));
        System.out.println(ad.findElementByXPath("//android.view.View[@text='Training Support']").getText());
        ad.findElementById("about-link").click();
        System.out.println(ad.findElementByAccessibilityId("About Us").getText());
    }

    @AfterClass
    public void close(){
        ad.close();
    }
}
