package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity1 {
    AndroidDriver<MobileElement> ad;

    @BeforeClass
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc =new DesiredCapabilities();
        dc.setCapability("deviceName", "Pixel 4 API 28");
        dc.setCapability("platformName", "Android");
        dc.setCapability("automationName", "UiAutomator2");
        dc.setCapability("appPackage", "com.android.calculator2");
        dc.setCapability("appActivity", ".Calculator");
        dc.setCapability("noReset", true);

        URL appserver = new URL("http://127.0.0.1:4723/wd/hub");
        ad = new AndroidDriver<MobileElement>(appserver, dc);
    }

    @Test
    public void calculator(){
        ad.findElementById("digit_4").click();
        ad.findElementById("op_mul").click();
        ad.findElementById("digit_6").click();
        ad.findElementById("eq").click();
        ad.findElementById("formula").getText().equals("24");
    }

    @AfterClass
    public void close(){
        ad.close();
    }
}
