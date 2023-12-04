package day_012_waits_alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import static day_012_waits_alerts.AlertsLocators.*;
import  java.time.Duration;


public class Alerts extends BaseClass {

    @Test
    public void alertButton(){
        driver.manage().window().maximize();
        driver.get(URL);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        click(alertsButton);

        Alert alert=driver.switchTo().alert();
        alert.accept();
        sleep(2000);
        click(confirmButton);
        sleep(2000);
        alert.dismiss();
        sleep(2000);
        driver.quit();

    }
    @Test
    public void alertTimmer() {
        driver.manage().window().maximize();
        driver.get(URL);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        click(timerAlertButton);
        wait.until(ExpectedConditions.alertIsPresent()).accept();

        //eger ; wait.until(ExpectedConditions.alertIsPresent()).accept(); kullanirsak
        //asagidaki alert islemlerini yapmaya gerek kalmaz
/*
        Alert alert=driver.switchTo().alert();
        alert.accept();
        sleep(2000);

        driver.quit();
        */
    }
        @Test
        public void  promtButto(){
            driver.manage().window().maximize();
            driver.get(URL);
            wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            click(promtButton);
            Alert alert=driver.switchTo().alert();
            alert.sendKeys("murat");
            alert.accept();


             sleep(3000);
        driver.quit();


    }
}
