package day_018_Cookies_FluentWait_Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class Scenario extends BaseClass {
    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    By username = By.cssSelector("#validationCustom01");
    By register = By.xpath("//button[text()=' Register ']");
    By invalidclass = By.xpath("//div[@class='invalid-feedback']");
    By contacNummer = By.xpath("(//input[@id='validationCustom05'])[1] ");
    By dateNummer = By.xpath("(//input[@id='validationCustom05'])[2] ");
    By payment = By.xpath("//select[@name='payment']");
    By assertt = By.xpath("//div[@class='alert alert-info']//p");

    //https://practice.expandtesting.com/form-validation sitesine gidin
    //Contact Name: adinizi girin
    //Register e tiklayin
    // veri girilemeyen field lerde hata oldugunu assert edin
    //diger verileri girin
    //sonra registere tiklayin
    // Thank you for validating your ticket yazildigini assert edin

    @Test
    public void test_Scenario() {
        String url = "https://practice.expandtesting.com/form-validation";

       /* new Actions(driver).moveToElement(driver.findElement(username))
                .sendKeys(Keys.chord(Keys.CONTROL,"a"))
                .sendKeys(Keys.DELETE)
                .sendKeys("Murat")
                .click(driver.findElement(register)).build().perform();
        */
        driver.get(url);
        WebElement element = driver.findElement(username);
        element.clear();
        element.sendKeys("Murat");
        click(register);
        List<WebElement> list1 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(invalidclass));

        /* long num=list1.stream().filter(e -> e.isDisplayed()).count(); // 2.bir yol
        Assert.assertEquals(num,3);*/

        int disp = 0;
        for (WebElement webElement : list1) {
            if (webElement.isDisplayed()) {
                disp++;
            }
        }

        Assert.assertEquals(disp, 3);


        WebElement contect = driver.findElement(contacNummer);
        contect.clear();
        contect.sendKeys("023-1234567");
        sendkeys(dateNummer, "10.11.2021");
        Select select = new Select(driver.findElement(payment));
        select.selectByIndex(1);
        click(register);
        wait.until(ExpectedConditions.visibilityOfElementLocated(assertt));
        driver.quit();


    }

    @Test
    public void test2() {
        By firstname = By.xpath("//input[@id='firstName']");
        By lastname = By.xpath("//input[@id='lastName']");
        By useremail = By.xpath("//input[@id='userEmail']");
        By gender=By.xpath("//input[@value='Male']");

        String url = "https://demoqa.com/automation-practice-form";
        driver.get(url);
       ((JavascriptExecutor) driver).executeScript("document.body.style.zoom='60%'"); // ekrani bu sekilde kuculttuk
       sendkeys(firstname,"Murat");
       sendkeys(lastname,"Tokar");
       sendkeys(useremail,"murattokar26@gmail.com");
      click3lü(gender);

       // driver.quit();
    }



}
