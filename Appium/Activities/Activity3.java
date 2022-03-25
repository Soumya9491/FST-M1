package activities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Activity3 {

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
    public void substract(){
        ad.findElementById("digit_1").click();
        ad.findElementById("digit_0").click();
        ad.findElementById("minus").click();
        ad.findElementById("digit_5").click();
        ad.findElementById("eq").click();
        Assert.assertEquals(ad.findElementById("formula").getText(), "5");
    }

    @Test
    public void add(){
        ad.findElementById("digit_5").click();
        ad.findElementById("plus").click();
        ad.findElementById("digit_9").click();
        ad.findElementById("eq").click();
        Assert.assertEquals(ad.findElementById("formula").getText(), "14");
    }

    @Test
    public void multiply(){
        ad.findElementById("digit_5").click();
        ad.findElementById("multiply").click();
        ad.findElementById("digit_1").click();
        ad.findElementById("digit_0").click();
        ad.findElementById("digit_0").click();
        ad.findElementById("eq").click();
        Assert.assertEquals(ad.findElementById("formula").getText(), "500");
    }

    @Test
    public void divide(){
        ad.findElementById("digit_5").click();
        ad.findElementById("digit_0").click();
        ad.findElementById("divide").click();
        ad.findElementById("digit_2").click();
        ad.findElementById("eq").click();
        Assert.assertEquals(ad.findElementById("formula").getText(), "25");
    }

    @AfterClass
    public void close(){
        ad.close();
    }
}
