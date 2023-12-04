package day_010_formElemets_checkbox_scroll;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class ImlicitlyWait {
    /**
     * ImplicitlyWait: driver bünyesindedir.Bu bekleme element precence oluncaya kadar her element icin beklenir
     * Explicit wait:
     * Fluent wait:
     *
     */
    WebDriver driver;
    @Test
    public void test1(){
        driver= Driver.getDriver();
        // findElement ile aranan tum elementler icin max 10 sn bekler
        //default olarak her yarim sn de bir kontrol eder
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

}
