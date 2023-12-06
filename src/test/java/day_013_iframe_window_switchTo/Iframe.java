package day_013_iframe_window_switchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.time.Duration;

public class Iframe extends BaseClass {
    String url = "https://bonigarcia.dev/selenium-webdriver-java/iframes.html";
    By lorem = By.xpath("//*[contains(text(),'Lorem ipsum')]");
    By liframe = By.id("my-iframe");


    @Test
    public void test1() {
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.switchTo().frame("my-iframe"); // id ile switch edilir

        // element ile switch edilebilir
        // WebElement iframe=driver.findElement(liframe);
        // driver.switchTo().frame(iframe);

        // index ile de switch edilebilir
        // driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lorem));

        driver.quit();

    }

    @Test
    public void test2() {
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // index ile de switch edilebilir
        driver.switchTo().frame(0);


        // burda h5 in text ini almak icin iframe nin disina cikmaliyiz
        wait.until(ExpectedConditions.visibilityOfElementLocated(lorem));
        driver.switchTo().parentFrame();
        String h5 = driver.findElement(By.cssSelector("h5")).getText();
        System.out.println(h5);

        driver.quit();

    }

    @Test
    public void testNestedFrames() {


       // By iframee1=By.id("frame1");
        String iframe="frame1";
        By childIframe=By.xpath("//*[contains(text(),'Child Iframe')]");
        String urll="https://demoqa.com/nestedframes";


        driver.manage().window().maximize();
        driver.get(urll);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.switchTo().frame(iframe);



        driver.switchTo().frame(0);
        System.out.println(driver.findElement(childIframe).getText());

        driver.switchTo().parentFrame();
        System.out.println(driver.findElement(By.cssSelector("body")));


        //  WebElement childIframee= driver.findElement();
      // driver.switchTo().frame(childIframee);


        driver.quit();
    }
    @Test
    public void testNestedFrames1() {
        String ifare="mce_0_ifr";
        By bold=By.xpath("//button[@aria-label='Bold']");
        By textClear=By.xpath("//p[text()='Your content goes here.']");
        By childIframe=By.xpath("//*[contains(text(),'Child Iframe')]");
        String urll="https://the-internet.herokuapp.com/iframe";
        driver.manage().window().maximize();



        driver.get(urll);

        driver.findElement(bold).click();
        driver.switchTo().frame(ifare);
        WebElement text= driver.findElement(textClear);
        text.clear();
        text.sendKeys("Murat");
        sleep(5000);
    //  driver.switchTo().




        driver.quit();
    }
}