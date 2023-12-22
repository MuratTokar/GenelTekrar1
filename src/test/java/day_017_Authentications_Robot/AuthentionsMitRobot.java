package day_017_Authentications_Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class AuthentionsMitRobot extends BaseClass {
    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    String url = "https://the-internet.herokuapp.com/";
    By basicAuth = By.xpath("//a[text()='Basic Auth']");
    @Test
    public void robottt() throws AWTException {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(basicAuth)).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));
        Robot robot1=new Robot();
        rob("admin");
        robot1.keyPress(KeyEvent.VK_TAB);
        rob("admin");
        robot1.keyPress(KeyEvent.VK_TAB);
        robot1.keyPress(KeyEvent.VK_ENTER);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()='Basic Auth']")));
        sleep(3000);
        driver.quit();




            
        }
        public void rob(String str) throws AWTException {
            Robot robot=new Robot();
            for (int i = 0; i <str.length() ; i++) {
                robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));
            }


        }


    }
