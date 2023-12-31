package day_023_xml_introduction_parallelTest.Xml3;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class Test1 extends TestbaseClass {
    By username = By.xpath("//input[@name='username']");
    By password = By.xpath("//input[@name=\"password\"]");
    By loginbut = By.xpath("//button[@type=\"submit\"]");
    By userdropdown=By.xpath("//p[@class=\"oxd-userdropdown-name\"]");
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // instance driver ile run ettim paralel testi
    @Test
    public void test1() {

        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    }

    @Test(dependsOnMethods = "test1")
    public void fillLoginForm(){
        driver.findElement(username).sendKeys("Admin");
        driver.findElement(password).sendKeys("admin123");
        driver.findElement(loginbut).click();
    }
    @Test(dependsOnMethods = "fillLoginForm")
    public void assertlogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userdropdown));
    }

}
