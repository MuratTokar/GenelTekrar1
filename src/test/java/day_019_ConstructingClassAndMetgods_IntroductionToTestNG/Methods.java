package day_019_ConstructingClassAndMetgods_IntroductionToTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods {

    WebDriver driver;
    WebDriverWait wait;

    Methods(Browsers browser) {
        switch (browser) {
            case Edge:
                driver = new EdgeDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            default:
                driver = new ChromeDriver();


        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void get(String url) {
        driver.get(url);

    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);

    }

    public void clickAlternative(By locator) {
        wait.until(d -> {
            try {
                d.findElement(locator).click();
                return true;
            } catch (Exception e) {
                try {
                    new Actions(d)
                            .scrollToElement(d.findElement(locator))
                            .click()
                            .perform();
                    return true;
                } catch (Exception e1) {
                    try {
                        WebElement element = d.findElement(locator);
                        JavascriptExecutor executor = (JavascriptExecutor) driver;
                        executor.executeScript("arguments[0].click", element);
                        return true;
                    } catch (Exception e2) {
                        return false;

                    }


                }


            }

        });

    }

    public void clickAlterr(WebElement element){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        }catch (Exception e){
            try {
                new Actions(driver).click(element).perform();

            }catch (Exception e1){
                try {
                    JavascriptExecutor executor= (JavascriptExecutor) driver;
                    executor.executeScript("arguments[0].click",element);

                }catch (Exception e2){
                    throw new RuntimeException("Element not clickable");

                }

            }

        }


    }
    public void sendkeys(By locator,String name){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        sendkeys(element,name);

    }
    public void sendkeys(WebElement element,String name){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(name);


    }
    public void hover(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        new Actions(driver)
                .moveToElement(element)
                .perform();


    }
    public void hover(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        hover(element);
    }
}

