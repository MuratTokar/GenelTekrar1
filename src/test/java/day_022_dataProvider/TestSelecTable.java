package day_022_dataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class TestSelecTable {
    String url = "https://jqueryui.com/selectable/#default";
    By dsplaye = By.xpath("//a[text()='Display as grid']");
    By iframeclass = By.xpath("//*[@class=\"demo-frame\"]");
    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void aftertest() {
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(dsplaye)).click();
        driver.switchTo().frame(driver.findElement(iframeclass));

    }

    @Test(dependsOnMethods = {"test1"})
    public void testselect() {
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .click(num(1))
                .pause(100)
                .click(num(3))
                .pause(100)
                .click(num(5))
                .pause(100)
                .click(num(7))
                .pause(100)
                .click(num(9))
                .pause(100)
                .click(num(11))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(dsplaye)).click();
        driver.switchTo().frame(driver.findElement(iframeclass));
        int[] arr={1,2,5,7,9};
        for (int i : arr) {
            new Actions(driver)
                    .keyDown(Keys.CONTROL)
                    .click(num(i))
                    .keyUp(Keys.CONTROL)
                    .build()
                    .perform();


        }
    }
    public WebElement num(int num) {
        return driver.findElement(By.xpath("//li[text()='" + num + "']"));
    }
}
