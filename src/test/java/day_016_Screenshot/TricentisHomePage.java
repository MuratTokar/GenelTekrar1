package day_016_Screenshot;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TricentisHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    //variable locators
  private String url = "https://demowebshop.tricentis.com/";

  private By lsearchBox = By.xpath("//input[@id='small-searchterms']");
   private By lsearchButton = By.xpath("//input[@value='Search']");
    private By lresults = By.xpath(".//div[@class='item-box']/div"); // nokta aktif elemnti belirtir
    private By lresult = By.xpath("//div[@class='search-results']");

    public TricentisHomePage(WebDriver driver){
        this.driver=driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void maximize(){
        driver.manage().window().maximize();

    }
    public void checkTitle(String title){
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void search(String textToSearch){
        wait.until(ExpectedConditions.visibilityOfElementLocated(lsearchBox)).sendKeys("comp");
        wait.until(ExpectedConditions.elementToBeClickable(lsearchButton)).click();
    }


    public List<WebElement> getProductList(){
        WebElement searchrest = wait.until(ExpectedConditions.presenceOfElementLocated(lresult));
        return searchrest.findElements(lresults);

    }
    public void gtakeScreenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name="Resim"+now+".png";
        File target = new File("ScreenShot/"+name);
        FileUtils.copyFile(source, target);


    }
    public void gtakeElementScreenShot(WebElement element) throws IOException {
        File source = element.getScreenshotAs(OutputType.FILE);
        String now= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss"));
        String name="ResimElement"+now+".png";
        File target = new File("ScreenShot/"+name);
        FileUtils.copyFile(source, target);


    }



    public void open() {
        driver.get(url);
    }
}
