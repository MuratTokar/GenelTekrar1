package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline2.pageObject;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SdBaseTest {
    WebDriver driver;
    WebDriverWait wait;

    public SdBaseTest(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public void click(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element)).click();
    }
    public void sendkeys(WebElement element,CharSequence...text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }

    public void click2(WebElement element){
        wait.until(driver->{
            try {
                element.click();
                return  true;
            }catch (StaleElementReferenceException e){
                return false;
            }catch (Exception e){
                return false;
            }

                }
                );
    }
    public void waitforvisibity(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
