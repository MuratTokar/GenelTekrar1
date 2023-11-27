package day_11_imlicitly_explicitly_wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class Tests2 {
    WebDriver driver;
    WebDriverWait wait;
    String url="https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";
    By done=By.cssSelector("#text");


    By buttonRemove=By.xpath("//button[text()='Remove']");
    By checkbox=By.xpath("//div[@id='checkbox']");
    By add=By.xpath("//button[text()='Add']");
    By checkb=By.xpath("//input[@id='checkbox']");



    By buttonenable=By.xpath("//button[text()='Enable']");
    By enable=By.xpath("//p[@id='message']");
    By buttondisable=By.xpath("//button[text()='Disable']");
    By isdseble=By.xpath("//p[@id='message']");
    @Test
    public void test(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(done));
        driver.quit();

    }
    @Test
    public void test2(){
        String url="https://the-internet.herokuapp.com/dynamic_controls";
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(url);
        // Remove butonunu tikla
        driver.findElement(buttonRemove).click();
        // checkbox un invisible oldugunu assert et
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkbox));
        // Add butonuna tikla
        driver.findElement(add).click();
        //heckbox un visible oldugunu assert et
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkb));
        //enable butonuna tikla
        driver.findElement(buttonenable).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(enable));
        driver.findElement(buttondisable).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(isdseble));
        driver.quit();
    }
}
