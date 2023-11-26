package day_009_Driver;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.util.List;

public class Test1 {
    public Test1() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();

    }

    WebDriver driver;
    By username = By.xpath("//input[@id='username']");
    By password = By.xpath("//input[@id='password']");
    By submit = By.xpath("//button[@type='submit']");
    By assert1 = By.xpath("//h1[text()='Secure Area']");
    By logout = By.xpath("//a[@class='button secondary radius']/i[text()=' Logout']");
    By logassert = By.xpath("//h1[text()='Login Page']");
    String url = "https://practice.expandtesting.com/login";
    String name = "practice";
    String pssword = "SuperSecretPassword!";
    By drop = By.xpath("//select[@name='dropdown']");

    @Test
    public void test1() {

        driver.get(url);
        sendkeys(username, name);
        sendkeys(password, pssword);
        System.out.println(driver.findElement(submit).getCssValue("background-color"));
        click(submit);
        assertt(assert1);
        click(logout);
        assertt(logassert);
        driver.quit();
    }

    @Test
    public void selectBox() {
        //https://testpages.eviltester.com/styled/basic-html-form-test.html - siesine git
        String url2 = "https://testpages.eviltester.com/styled/basic-html-form-test.html";
        driver.get(url2);

        WebElement selectElemnt = driver.findElement(drop);
        Select select1 = new Select(selectElemnt);
        select1.selectByIndex(3);// 3.index tekini secti
        sleep(5000);

        select1.selectByValue("dd6");// valuesine gore secti
        sleep(5000);
        select1.selectByVisibleText("Drop Down Item 1"); //visible olandardan secti

        System.out.println("select1.isMultiple() = " + select1.isMultiple());


        List<WebElement> options = select1.getOptions();
        for (WebElement option : options) {
            System.out.println(option.getText());


        }
        driver.quit();


    }
    @Test
    public void elemntInElment(){

        String url3 = "https://testpages.eviltester.com/styled/basic-html-form-test.html";
        driver.get(url3);


        By lform=By.cssSelector("#HTMLFormElements");
        WebElement form=driver.findElement(lform);

        By input=By.xpath(".//input[@type='text' and not(@hidden)]");
      // driver.findElement(input).sendKeys("name"); // boyle yapabilirim
        // elemnt altinda elemnt ariyorsak  ve xpath kullaniyorsak  xpath in basina  . eklenir, .=current element
        form.findElement(input).sendKeys("name");// aramayi form ile sinirlayip form icinde input u aradik

        driver.findElement(By.xpath(".//")).findElement(By.id("")).findElement(By.name("")); // bu sekilde
        // element altinda element arayayabiliriz

        // bazi elentleri tiklayip lo0cate etmek istedigimizde yanip soner gibi kaybolur ve locator alamayiz.
        // Bunu bulmak ucun chrome pause metodu kullanilir



    }


    public void sendkeys(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();

    }

    public void assertt(By locator) {
        Assert.assertTrue(driver.findElement(locator).isDisplayed());
    }

    public void scrollActions(WebElement element) {
        new Actions(driver).scrollToElement(element).perform();

    }

    public void jcScroll(int num) {
        ((JavascriptExecutor) driver).executeScript("Window.scrollBy(0," + num + ")");

    }

    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
