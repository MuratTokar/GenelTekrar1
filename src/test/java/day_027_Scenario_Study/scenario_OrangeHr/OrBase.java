package day_027_Scenario_Study.scenario_OrangeHr;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverStatic;



public class OrBase {
  WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void beforeTest() {
        driver = DriverStatic.getDriver("chrome");
        driver.manage().window().maximize();


    }

    @AfterTest
    public void AfterTest() {
     //  DriverStatic.quit();
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sendkeys(WebElement element,CharSequence text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }
    public void scrol(WebElement element){
        new Actions(driver).scrollToElement(element)
                .perform();
    }
    public void jcscroll(String name){
        JavascriptExecutor ec= (JavascriptExecutor) driver;
        ec.executeScript("window.scrollTo(0,"+name+")");
    }
}
