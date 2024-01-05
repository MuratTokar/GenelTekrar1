package day_026_TestNG_Reporter_Extentreports;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGReport {
    /* BASIT RAPOR ALMAK ICIN

    * Burda testlerle ilgili rapor almak icin ya ustte run u tiklayip Edit CONFIGURATION U tiklariz ve orda TestNG seceriz
    * Yada sayfada sag tiklayip Modfy Run Configuration tiklariz  ORDAN TESTNG ve Listener seceriz ve sol altta + ya tiklayip
    arama yerine Report yaziyoruz EmailAbleReport seceriz.Testi run edince solda Test-Output altinda basit bir rapor cikar*/

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }
    @Test
    public void test3(){
        Assert.assertEquals(2,1);
    }
}
