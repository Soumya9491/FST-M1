package activities;

import io.appium.java_client.MobileBy;
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
import java.util.List;

public class Activity6 {
    AndroidDriver<MobileElement> ad;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "<Your device name>");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.android.chrome");
        dc.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        dc.setCapability("noReset", true);
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        ad = new AndroidDriver<>(appServer, dc);
        wait = new WebDriverWait(ad, 10);
        ad.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void scroll() {
        wait.until(ExpectedConditions.textToBePresentInElement(ad.findElementByAccessibilityId("Lazy Loading"), "Lazy Loading"));
        List<MobileElement> images = ad.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println(images.size());
        ad.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
        images = ad.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
        System.out.println(images.size());
    }

    @AfterClass
    public void afterClass() {
        ad.quit();
    }
}
