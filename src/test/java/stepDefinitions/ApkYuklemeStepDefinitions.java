package stepDefinitions;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApkYuklemeStepDefinitions {

    @Given("Kullanici gerekli kurulumlari yaparak apk yukleme {string} islemini gerceklestirir")
    public void kullaniciGerekliKurulumlariYaparakApkYuklemeIsleminiGerceklestirir(String apk) throws MalformedURLException {
        AndroidDriver<AndroidElement> driver; //android cihazlarin driveri
        final String cihazAdi="PIXEL2";
        final String platformIsmi="Android";
        final String version="10.0";
        final String automation="UiAutomator2";

        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,cihazAdi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformIsmi);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,automation);
        capabilities.setCapability(MobileCapabilityType.APP,ConfigReader.getProperty(apk));

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
}
