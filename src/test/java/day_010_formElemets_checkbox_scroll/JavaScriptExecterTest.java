package day_010_formElemets_checkbox_scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

public class JavaScriptExecterTest extends BaseClass {
    /*
     * sayfada kaydirma islemleri javascriptExecuter ile yapilir
     * scrollBy(x,y) : bulundugu yerden x kadar saga/sola ,y kadar asagi/yukari  kaydirir
     * scrollTo(x,y)  : x,y noktasina git.static bir noktaya gider
     * scrollIntoView(): belirtilen elemente kadar scroll eder*/
    String url = "https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html";

    @Test
    public void text_scrollBy() {
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        sleep(2000);


    }

    @Test
    public void text_scrollBy1() {
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();


        for (int i = 0; i < 10; i++) { //10 birim asagi kaydi
            jcScroll(200);
            sleep(2000);
        }
        for (int i = 0; i < 5; i++) { //10 birim asagi kaydi
            jcScroll(-200);
            sleep(2000);
        }
        driver.quit();
    }

    @Test
    public void text_scrollTo() {
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(100,500)");
        sleep(2000);
    }

    @Test
    public void text_scrollTo2() {
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        sleep(3000);
        jcScriptscrollTo(100, 300);
        sleep(2000);
    }

    @Test
    public void text_scrollToview() {
        By l=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement element=driver.findElement(l);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        driver.quit();
    }
    @Test
    public void text_scrollToview2() {
        By l=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement element=driver.findElement(l);
        JcScrollIntoview(element,false);// false deyince ekranin altina gelir
        driver.quit();
    }
    @Test
    public void text_scrollToview3() {
        // yukaridaki elenti sayfanin ortasina yerlestirin
        By l=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        driver = Driver.getDriver();
        driver.get(url);
       driver.manage().window().maximize();
        WebElement element=driver.findElement(l);
        JcScrollIntoview(element,false);
        sleep(4000);
        int y=driver.manage().window().getSize().height/2;
        jcScroll(y);
        sleep(5000);
        driver.quit();
    }
    @Test
    public void text_scrollToview4() {
        // yukaridaki elenti sayfanin ortasina yerlestirin
        By l=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        driver = Driver.getDriver();
        driver.get(url);
        driver.manage().window().maximize();
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("document.body.style.zoom='50%'");//acilan sayfayi yuzde elli kuculttu
        WebElement element=driver.findElement(l);
        JcScrollIntoview(element,false);
        sleep(4000);
        int y=driver.manage().window().getSize().height/2;
        jcScroll(y);
        sleep(5000);
        driver.quit();
    }
}