package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.AppPage.AileButcemPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

public class aileButcemStep {
   AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
   TouchAction action=new TouchAction<>(driver);
   AileButcemPage page=new AileButcemPage();
    @Given("Kullanici kurulumlari tamamlar")
    public void kullanici_kurulumlari_tamamlar() {
        Driver.getAndroidDriver();
    }

    @Then("ilk ekran ayarlarini yapar ve {string} a tiklayin ve ardindan login sayfasina ulasin")
    public void ilkEkranAyarlariniYaparVeATiklayinVeArdindanLoginSayfasinaUlasin(String girisyap) {
        ReusableMethods.wait(2);
        for (int i=0;i<6; i++){
            action.press(PointOption.point(924,933))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).
                    moveTo(PointOption.point(125,933)).release().perform();
        }
        ReusableMethods.scrollWithUiScrollable(girisyap);
    }

    @Then("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string}")
    public void veBilgileriniGirerekKullaniciBilgileriyle(String mail, String sifre, String girisyap) {
        page.mailBox.sendKeys(ConfigReader.getProperty(mail));
        page.passwordBox.sendKeys(ConfigReader.getProperty(sifre));
        ReusableMethods.scrollWithUiScrollable(girisyap);
    }
    @Then("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamaya_kullanici_bilgileriyle_giris_yapildigini_dogrulayin() {
        ReusableMethods.wait(1);
       page.girisBasariliMethodu();
    }
    @Then("sol kisimdaki menuden {string} bolumune gidin")
    public void solKisimdakiMenudenBolumuneGidin(String hesabim) {
       ReusableMethods.wait(6);
        page.solUstMenu.click();
        ReusableMethods.scrollWithUiScrollable(hesabim);
    }

    @Then("hesabim sayfasindaki bilgileri {string} {string} {string} {string} {string} degistirerek degisikleri kaydedin")
    public void hesabimSayfasindakiBilgileriDegistirerekDegisikleriKaydedin(String isim, String soyismim, String sehir, String yas, String meslegim) {
    page.hesabimBilgiDegisikligi(ConfigReader.getProperty(isim),
            ConfigReader.getProperty(soyismim),ConfigReader.getProperty(sehir),ConfigReader.getProperty(yas),ConfigReader.getProperty(meslegim));

    }
    @Then("ardindan degisiklerin yapildigini dogrulayin")
    public void ardindan_degisiklerin_yapildigini_dogrulayin() {
     page.hesapBilgiDegisikliAssert();
    }



}
