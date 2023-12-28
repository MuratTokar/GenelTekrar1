package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.demoblaze;

import day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.demoblaze.Locators;
import day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.demoblaze.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestDemoBlase {
    WebDriver driver;
    WebDriverWait wait;

    Locators ls;


    @BeforeTest
    public void start() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // ls= PageFactory.initElements(driver,Locators.class);
        // locator class da pagefactory ve driver icin concstructor a gerek kalmadi
    }

    @Test
    public void test() {
        ls = new Locators(driver);
        driver.get(ls.url);
        ls.phoneslink.click();
        utils.BaseClass.sleep(3000);
        for (WebElement element : ls.productsNameList) {
            System.out.println(element.getText());

        }


    }

    @Test
    public void test_FindByVsFindBys() {
       ls = new Locators(driver);
        driver.get(ls.url);
        ls.phoneslink.click();
        utils.BaseClass.sleep(3000);
        for (WebElement element : ls.productsNameList) {
            System.out.println(element.getText());


        }
    }
    @Test
    public void test_FillTheProductClass() {
        ls = new Locators(driver);
        driver.get(ls.url);
        //ls.phoneslink.click();
        List<Product> products=new ArrayList<>();
        for (WebElement product : ls.productss) {
            WebElement link=product.findElement(By.cssSelector("a"));
            String name=link.getText();
            String pricestr=product.findElement(By.cssSelector("h5")).getText();
            int price=Integer.parseInt(pricestr.replaceAll("[^0-9]","").trim());
            String description=product.findElement(By.id("article")).getText();
            products.add(new Product(link,name,price,description));
            for (Product product1 : products) {
                System.out.println(product1);

            }


        }





    }

    @AfterTest
    public void aftertest() {
        // driver.quit();
    }

}