package day_017_Authentications_Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;

public class ActionOffset extends BaseClass {

    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    String url="https://www.snapdeal.com/product/hmct-615-metal-analog-mens/652415109752#bcrumbSearch:watch";
    By watch=By.xpath("(//*[@id=\"bx-slider-left-image-panel\"]//img)[1]");
    By ccokise=By.xpath("//div[@id=\"adroll_allow_all\"]//div");
    @Test
    public void testOffset(){
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ccokise)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ccokise));
        WebElement element=driver.findElement(watch);
        new Actions(driver).moveToElement(element).perform();
        //Actions classinda moveToElement(element) ---> o elementin orta noktasina click eder
        // moveToElement(element,xOffset,yOffset)--> ise o elemntin x ve y koordinatlarini click eder
        // ekranin sol ust kösesi 0 dir
        // sag a giden ve alta inen x ve y nin art kismidir.sol ve uste giden x ve y nin eksi kismidir
        // zanı saga gıden +x  sola gıden -x ,yukari giden -y asagi inen +y dir
        move(element,-100,100);
        sleep(2000);
        move(element,100,100);
        sleep(2000);
        move(element,100,-100);
        sleep(2000);
        move(element,-100,100);

        driver.quit();

    }
    @Test
    public void testOffset1(){
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(ccokise)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(ccokise));
        WebElement element=driver.findElement(watch);

        int width=element.getSize().getWidth(); // saatin genisligi
        int heigth=element.getSize().getHeight(); // yuksekligi aldik

        int x=width/2;
        int y=heigth/2;
        for (int i = 0; i <heigth; i++) {
            move(element,0,-y+i);
            sleep(500);
        }

        driver.quit();


    }


}
