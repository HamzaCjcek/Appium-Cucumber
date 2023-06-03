package pages.AppPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.BrowserDriver;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AileButcemPage {
    public AileButcemPage() {
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
    }

    @FindBy(xpath = "//*[@text='E-mail Adresi']")
    public MobileElement mailBox;

    @FindBy(xpath = "//*[@text='Şifre']")
    public MobileElement passwordBox;

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    private MobileElement girisBasariliText;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public MobileElement solUstMenu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    private MobileElement isimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    private MobileElement soyisimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    private MobileElement sehirKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    private MobileElement yasKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    private MobileElement meslekKutusu;

    public void hesabimBilgiDegisikligi(String isim,String soyisim,String sehir,String yas,String meslek){
        isimKutusu.clear();
        isimKutusu.sendKeys(isim);

        soyisimKutusu.clear();
        soyisimKutusu.sendKeys(soyisim);

        sehirKutusu.clear();
        sehirKutusu.sendKeys(sehir);

        yasKutusu.clear();
        yasKutusu.sendKeys(yas);

        meslekKutusu.clear();
        meslekKutusu.sendKeys(meslek);

        ReusableMethods.scrollWithUiScrollable("Kaydet");
    }

    public void hesapBilgiDegisikliAssert(){
        String actualIsim=isimKutusu.getText();
        String expected= ConfigReader.getProperty("isim");
        assertEquals("bilgiler Uyusmuyor",expected,actualIsim);


        String actualSoyisim=soyisimKutusu.getText();
        String expectedSoyisim=ConfigReader.getProperty("soyisim");
       assertEquals("bilgiler Uyusmuyor",expectedSoyisim,actualSoyisim);


       String actualSehir=sehirKutusu.getText();
       String expectedSehir=ConfigReader.getProperty("sehir");
       assertEquals("BILGILER DOGRU DEGIL",expectedSehir,actualSehir);

       String actualYas=yasKutusu.getText();
       String expectedYas=ConfigReader.getProperty("yas");
       assertEquals("bilgiler yanlisdur uasgum",expectedYas,actualYas);

       String acutalMeslek=meslekKutusu.getText();
       String expectedMeslek=ConfigReader.getProperty("meslek");
       assertEquals("bilgiler uyusmaz",expectedMeslek,acutalMeslek);


    }

    public void girisBasariliMethodu(){
        String actual=  girisBasariliText.getText();
        String expected="Başarıyla giriş yapıldı.";
        assertEquals("Giris Basarisiz",expected,actual);

    }
}
