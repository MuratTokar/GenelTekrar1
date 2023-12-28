package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Demoqa {
    String url="https://demoqa.com/progress-bar";
    WebDriver driver;
    WebDriverWait wait;
    By startt =By.id("startStopButton");
    By progesbar=By.xpath("//div[@id='progressBar']//div");
    @BeforeTest
    public void start(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @AfterTest
    public void aftertest(){

      driver.quit();
    }

    @Test
    public void test1() {

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(startt));



    }
    @Test(dependsOnMethods = "test1")
    public void test2() throws IOException {
      click(startt);
       int prozent=0;
       do {
           String vall=driver.findElement(progesbar).getAttribute("aria-valuenow");
           prozent=Integer.parseInt(vall);

       } while (prozent<=80);
       click(startt);
        gscreenShot("deneme");


    }








    public void gscreenShot(String name) throws IOException {
        TakesScreenshot screenshot= (TakesScreenshot) driver;
        File source= screenshot.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH-mm-ss"));
        String Filename=name+now+".png";
        File target=new File(Filename);
        FileUtils.copyFile(source,target);

    }
    public void screenShotElement(By locator,String name) throws IOException {
        WebElement element1=driver.findElement(locator);
        File source=element1.getScreenshotAs(OutputType.FILE);
        File target=new File(name+".png");
        FileUtils.copyFile(source,target);
    }
    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }




}
