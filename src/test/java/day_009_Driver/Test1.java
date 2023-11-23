package day_009_Driver;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

public class Test1 {
    public Test1(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();

    }
    WebDriver driver;
    By username=By.xpath("//input[@id='username']");
    By password=By.xpath("//input[@id='password']");
    By submit=By.xpath("//button[@type='submit']");
    By assert1=By.xpath("//h1[text()='Secure Area']");
    By logout=By.xpath("//a[@class='button secondary radius']/i[text()=' Logout']");
    By logassert=By.xpath("//h1[text()='Login Page']");
    String url="https://practice.expandtesting.com/login";
    String name="practice";
    String pssword="SuperSecretPassword!";

    By username2=By.xpath("//input[@name='username']");
    By pass2=By.xpath("//input[@name='password']");
    By textArea=By.xpath("//*[@name='comments']");
    By textbox1=By.xpath("//input[@name='checkboxes[]' and @value='cb1']");
    By radio1=By.xpath("//input[@name='radioval' and @value='rd1']");
    String url2="https://testpages.eviltester.com/styled/basic-html-form-test.html";
    By select=By.xpath("//select[@name='multipleselect[]']");
    By drop=By.xpath("//select[@name='dropdown']");

    @Test
    public void test1(){

        driver.get(url);
        sendkeys(username,name);
        sendkeys(password,pssword);
        System.out.println(driver.findElement(submit).getCssValue("background-color"));
        click(submit);
        assertt(assert1);
        click(logout);
        assertt(logassert);
        driver.quit();
    }

    @Test
    public void selectBox(){
        //https://testpages.eviltester.com/styled/basic-html-form-test.html - siesine git
        driver.get(url2);
        sendkeys(username2,"Murat");
        sendkeys(pass2,"123456789");
        sendkeys(textArea,"merhebeler");
        click(textbox1);
        click(radio1);

        WebElement selectElemnt=driver.findElement(select);
        Select select1=new Select(selectElemnt);
        select1.selectByIndex(0);
        click(drop);

    }




    public void sendkeys(By locator,String text){
        WebElement element=driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator){
        WebElement element=driver.findElement(locator);
        element.click();

    }
    public void assertt(By locator){
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }
}
