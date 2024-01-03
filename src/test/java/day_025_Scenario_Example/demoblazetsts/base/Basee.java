package day_025_Scenario_Example.demoblazetsts.base;


import day_025_Scenario_Example.demoblazetsts.driverr.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Basee {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    @Parameters("browser")
    public void beforetst(@Optional("Chrome") String browser) {  //@Optional("Chrome")  boylece sadece xml de degil test classta da run edebiliriz
        driver = Driver.getdriver(browser);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterTest
    public void aftertest(){
       // ScreenShort("DemoBlaze");
        driver.quit();


    }

    public void clickk(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void senkeys(WebElement element, CharSequence... text) {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public static void ScreenShort(String name){
        TakesScreenshot ss = (TakesScreenshot) Driver.getdriver();
        File source = ss.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy-MM-dd HH-mm-ss"));
        File target = new File(name + now + ".png");
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

