package day_019_ConstructingClassAndMetgods_IntroductionToTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_2Sample {
    // testler isim sirasina gore calisir
    // eger @Test(name) boyle isimlendirsek verdigimiz isme gore calisir
    //TestNG de test metotlarina priority veya dependency verilmez ise siralama netoto isimlerine goredir
    WebDriver driver;
    @BeforeClass
    public void beforeclass(){
        driver=new ChromeDriver();
    }
    @Test(testName ="T2",priority = 2)
    public void test1(){

        driver.get("https://google.com");
    }

    @Test(testName = "T3",priority = 1)
    public void test3(){
        driver.get("https://yahoo.com");
    }
    @AfterClass
    public void afterclass(){
        utils.BaseClass.sleep(3000);
        driver.quit();
    }
}
