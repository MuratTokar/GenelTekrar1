package day_012_waits_alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Selektable {
    String url = "https://demoqa.com/selectable";
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait;
    By listElement = By.xpath("//ul[@id='verticalListContainer']//li ");

    @Test
    public void test1() {
        driver.manage().window().maximize();
        driver.get(url);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        List<WebElement> liste = driver.findElements(listElement);
      //  jcScroll(100);
        liste.get(new Random().nextInt( 4)).click();

       BaseClass.sleep(3000);

        liste=driver.findElements(listElement);
        liste.forEach(e -> {
            if (e.getAttribute("class").contains("active"))
        e.click();} );
        Driver.quit();







    }
    @Test
    public void clickButtons(){
      //  By button1=By.cssSelector("#button00");
        By assertt=By.cssSelector("#buttonmessage");
        String url="https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(url);


       /* buttonsClick("#button00");
        buttonsClick("#button01");
        buttonsClick("#button02");
        buttonsClick("#button03");
        Assert.assertTrue(driver.findElement(assertt).isDisplayed());*/

        // yada soyle yapabiliriz
        By[] locators={
                By.cssSelector("#button00"),
                By.cssSelector("#button01"),
                By.cssSelector("#button02"),
                By.cssSelector("#button03"),

        };
        for (int i = 0; i <locators.length ; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locators[i])).click();

        }
        Assert.assertEquals(driver.findElement(assertt).getText(),"All Buttons Clicked");

       // wait.until(ExpectedConditions.elementToBeClickable(button1)).click();
    }






public void buttonsClick(String text) {
    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(text))).click();
}
    public void click(WebElement element){
        scrolMovito(element);
        element.click();
    }
    public void scrolMovito(WebElement element){
        new Actions(driver).moveToElement(element).perform();

    }
    public void jcScroll(int num){
        JavascriptExecutor executor=(JavascriptExecutor) driver;
        executor.executeScript("window.scrollBy(0,"+num+")");
    }

}
