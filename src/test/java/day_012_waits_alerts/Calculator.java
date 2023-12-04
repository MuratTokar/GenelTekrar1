package day_012_waits_alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;


import java.time.Duration;
import java.util.Random;

public class Calculator extends BaseClass {

    WebDriverWait wait;
    String url = "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html";
    By iki = By.xpath("//div[@class='keys']//*[contains(text(),'2')]");
    By arti = By.xpath("//div[@class='keys']//*[contains(text(),'+')]");
    By esittir = By.xpath("//div[@class='keys']//*[contains(text(),'=')]");
    By screen = By.cssSelector(".screen");


    @Test
    public void test() {

        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        click(iki);
        click(arti);
        click(iki);
        click(esittir);
        Assertt("6");
        driver.quit();

    }

    @Test
    public void randomIslem() {
        driver.get(url);
     //   Random r = new Random();
      //  int num1 = r.nextInt(100, 500);
      //  int num2 = r.nextInt(100, 500);

       // clickCalc(num1 + "");
        //clickCalc("+");
       // clickCalc(num2 + "");
        //clickCalc("=");

    }


    public void clickCalc(String num) {
        for (int i = 0; i < num.length(); i++) {
            click(getNumber(num.substring(i, i + 1)));

        }
    }

    public By getNumber(String num) {
        return By.xpath("//div[@class='keys']//*[contains(text(),'" + num + "')]");


    }

    public void Assertt(String num) {
        wait.until(ExpectedConditions.textToBe(screen, "" + num + ""));

    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }
}
