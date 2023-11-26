package day_008_locator_and_Scenario;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Scenarios {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = getDriver(); // burda ya boyle driver=getDriver i instance initilaizer ederim yada burda constructor icine yazarim
        // ama initiliazer consructordan once calisir
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By elents = By.xpath("//div[@class='category-cards']/div[.//*[text()='Elements']]/div");
    By table = By.xpath("//ul[@class='menu-list']/li[@id='item-3']");
    By delete = By.xpath("//span[@id='delete-record-1']");
    String url = "https://demoqa.com/";
    By edit=By.cssSelector("#edit-record-1");

    By firstName=By.cssSelector("#firstName");
    By lastName=By.cssSelector("#lastName");
    By email=By.cssSelector("#userEmail");
    By age=By.cssSelector("#age");
    By salary=By.cssSelector("#salary");
    By department=By.cssSelector("#department");
    By submit=By.cssSelector("#submit");
    By asert=By.xpath("//div[text()='Ali']");

    @Test
    public void scenario1() {
        /* https://demoqa.com/
        Elements linkine tikla
        WebTables e tikla
        Lasname Vega olan kaydi silin
        Kaydin silindigini assert edin
         *
         */


        driver.get(url);
        WebElement element = driver.findElement(elents);
        lcscroll(500);
        sleep(5000);

        element.click();
        click(table);
        click(delete);

        boolean b = false;
        try {
            driver.findElement(delete);
            b = true;
        } catch (Exception e) {

        }
        Assert.assertFalse(b);
        driver.quit();
    }

    @Test
    public void testEdit() {
        /*
        1-https://demoqa.com/
        2-WebTables e tiklayin
        3-Lasname Vega olan kaydi edit edin
        4-Acilan dialogbox daki formu gerekli bilgiler ile doldurun
        5-Fierst name degistirin
        6-Submit butonuna basarak kaydi guncelleyin
        7-ismin guncellendigini assert edin
        * */
        driver.get(url);
        WebElement element = driver.findElement(elents);
        lcscroll(500);
        sleep(5000);
        element.click();
        click(table);
        sleep(3000);
        click(edit);
        senkeys(firstName,"Ali");
        click(submit);
       Assert.assertTrue(driver.findElement(asert).getText().equalsIgnoreCase("Ali"));

       // driver.quit();
    }













    public WebDriver getDriver() {
        return new ChromeDriver();
    }

    public WebDriver getDriver(String browser) {
        switch (browser.toLowerCase().trim()) {
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();

        }

    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        scroll(element);
        element.click();
    }

    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scroll(WebElement element) {
        new Actions(driver)
                .scrollToElement(element)
                .perform();
    }

    public void lcscroll(int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ")");
    }
    public void senkeys(By locator,CharSequence text){
        WebElement element=driver.findElement(locator);
        scroll(element);
        element.clear();
        element.sendKeys(text);
    }

}
