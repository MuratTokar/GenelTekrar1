package day_11_imlicitly_explicitly_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class Tests {
    WebDriver driver;
    WebDriverWait wait;
    //"https://www.selenium.dev/selenium/web/dynamic.html adresine git
    // addbox butonuna tikla
    // erngini assert et
    String url = "https://www.selenium.dev/selenium/web/dynamic.html";
    By addBox = By.cssSelector("#adder");
    By color = By.cssSelector("#box0");

    By reveal=By.cssSelector("#reveal");
    By revelad=By.cssSelector("#revealed");
    @Test
    public void test_getRectColor() {


        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        click(addBox);
        WebElement element = driver.findElement(color);
        System.out.println(element.getCssValue("background-color"));
        System.out.println(element.isDisplayed());
        driver.quit();



    }

    @Test
    public void test_ExpcilityWait() {

       //"https://www.selenium.dev/selenium/web/dynamic.html adresine git
        // Revel a input butonuna tikla
        //Adini yazdir

        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        //burda hata verir.Element kodlarda var driver elementi buluyor  ancak sendkey edemiyor
        click(reveal);
        driver.findElement(revelad).sendKeys("Murat");
        Assert.assertTrue(driver.findElement(revelad).isEnabled());

       driver.quit();


    }
    @Test
    public void test_ExpcilityWait2() {

        //"https://www.selenium.dev/selenium/web/dynamic.html adresine git
        // Revel a input butonuna tikla
        //Adini yazdir

        driver = Driver.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));
        driver.get(url);
        driver.manage().window().maximize();

       // driver.findElement(reveal).click();
        wait.until(ExpectedConditions.elementToBeClickable(reveal)).click();
        WebElement input=wait.until(ExpectedConditions.visibilityOfElementLocated(revelad));
        input.sendKeys("Guidersoft");


       // driver.quit();


    }
        public void click (By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void sleep ( long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}