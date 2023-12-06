package day_013_iframe_window_switchTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.time.Duration;
import java.util.Set;

public class Windows extends BaseClass {
    By win1 = By.xpath("//button[@id='popupPage']");
    By win2 = By.xpath("//button[@id='popupAnonymous']");
    By win3 = By.xpath("//button[@id='popupBlank']");
    String url = "https://www.selenium.dev/selenium/web/rc/tests/html/test_select_window.html";
    By closePage = By.xpath("//input[@id='closePage2']");

    @Test
    public void test_getWindowHandle() {
        driver.manage().window().maximize();
        String url1 = "https://google.com";
        System.out.println(driver.getWindowHandle());
        driver.quit();

    }

    @Test
    public void test_getWindowHandles() {
        driver.manage().window().maximize();
        driver.get(url);
        click(win1);
        Set<String> wins = driver.getWindowHandles();
        System.out.println(wins);
        driver.quit();
    }

    @Test
    public void test_getWindowWin() {

        driver.manage().window().maximize();

        driver.get(url);
        click(win1);
        String mainwinn = driver.getWindowHandle();
        String childwinn = "";

        Set<String> wins = driver.getWindowHandles();

        for (String wins2 : wins) {
            if (!win2.equals(mainwinn)) {
                childwinn = wins2;
                break;
            }

        }

        driver.switchTo().window(childwinn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(closePage));

    }

    @Test
    public void test_win3() {
        // win3 tiklayin
        //win sayisinin 2 olmasini bekleyin
        // active window un handlesini alin
        // yeni winn e switch edin ve butona tiklayip kapatin
        //mainwinn eswitch edin

        driver.manage().window().maximize();
        driver.get(url);
        // wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        click(win3);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String activewin = driver.getWindowHandle();
        System.out.println(activewin);
        String childwin4 = "";
        Set<String> winss = driver.getWindowHandles();
        System.out.println(winss);
        for (String swinn4 : winss) {
            if (!swinn4.equals(childwin4)) {
                childwin4 = swinn4;
            }

        }
        driver.switchTo().window(childwin4);
        click(closePage);
        wait.until(ExpectedConditions.numberOfWindowsToBe(1));

        driver.switchTo().window(activewin);
        driver.quit();


    }

    @Test
    public void test_win4() {

        String url1 = "https://google.com";
        String url2 = "https://yahoo.com";
        String url3 ="https://demoqa.com";
        driver.get(url1);

        driver.switchTo().newWindow(WindowType.TAB).get(url2);
         sleep(2000);

         driver.close();// aktif olani kapatir
      sleep(2000);
         driver.quit();

    }
}

