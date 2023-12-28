package day_020_POM.Demoqa;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    String url="https://demoqa.com/text-box";
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(css = "#userName")
    public WebElement efullname;

    @FindBy(css = "#userEmail")
    public WebElement eusermail;

    @FindBy(css = "#currentAddress")
    public WebElement ecurrentadress;

    @FindBy(css = "#permanentAddress")
   public WebElement epermantadress;

    @FindBy(css = "#submit")
    public WebElement esubmit;

    public LoginPage(WebDriver driver){ // constructor o class a disardan veri almak icin kullanilir
        this.driver=driver;
        PageFactory.initElements(driver,this);
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void gotosite(){
        driver.get(url);
    }


    public void sendkeys(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);

    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void scroll(WebElement element){
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }
    public void scrolljc(int num){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+num+")");
    }

    public void fieldform(String fulname,String usermail,String currentadress,String permanetadress){
        sendkeys(efullname,fulname);
        sendkeys(eusermail,usermail);
        sendkeys(ecurrentadress,currentadress);
        sendkeys(epermantadress,permanetadress);
        scrolljc(300);
        click(esubmit);

    }

}
