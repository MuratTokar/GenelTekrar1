package day_005_selenium_Senario_click_sendkeys;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01TestSorceDemo extends BaseClass {
    String url = "https://www.saucedemo.com/";
    By lusername = By.id("user-name");
    By lPassword = By.id("password");
    By lLogin = By.id("login-button");
    By lProduckassort = By.xpath("//span[text()='Products']");

    By addToCart=By.id("add-to-cart-sauce-labs-bike-light");

    String username="standard_user";
    String password="secret_sauce";

    By lsepet = By.id("shopping_cart_container");

    By sepetteAssort=By.id("remove-sauce-labs-bike-light");

    By linkTest=By.linkText("Sauce Labs Bike Light");
    @Test
    public void testLogin() {
        /*
        * 1.https://www.saucedemo.com/" sitesine git
          2.login ol
          3."Sauce Labs Bike Light" ürününü sepete ekle
          4.ürünün eklendigini assert et
          5.sepete git
          6.spette "Sauca Lab Bike Light" urununun oldugunu assetr edin
*/
        driver.get(url);


        WebElement username = driver.findElement(lusername);
        username.clear();
        username.sendKeys("standard_user");

        WebElement pass = driver.findElement(lPassword);
        pass.clear();
        pass.sendKeys("secret_sauce");


        driver.findElement(lLogin).click();

        Assert.assertTrue(driver.findElement(lProduckassort).isDisplayed());


        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();



        Assert.assertTrue(driver.findElement(By.linkText("Sauce Labs Bike Light")).isDisplayed());


        sleep(5000);

        driver.quit();


    }

    @Test
    public void testLogin2() {
        /*
        * 1.https://www.saucedemo.com/" sitesine git
          2.login ol
          3."Sauce Labs Bike Light" ürününü sepete ekle
          4.ürünün eklendigini assert et
          5.sepete git
          6.spette "Sauca Lab Bike Light" urununun oldugunu assetr edin
*/


        // * 1.https://www.saucedemo.com/" sitesine git
        driver.get(url);

        driver.manage().window().maximize();


       // 2.login ol
          sendkeys(lusername,username);
          sendkeys(lPassword,password, Keys.ENTER);
               // click(lLogin); click metodu yerine enter kullandik.CharSequence yukarda kullanigimiz icin Enter ekleyebiliriz

        // login oldugunu assert ettik yani produckt basligi gorunsun
          Assert.assertTrue(driver.findElement(lProduckassort).isDisplayed());


       // 3."Sauce Labs Bike Light" ürününü sepete ekle
          click(addToCart);

        //4.ürünün eklendigini assert et
        Assert.assertTrue(driver.findElement(sepetteAssort).isDisplayed());

       //  5.sepete git
          click(lsepet);


          //6.spette "Sauca Lab Bike Light" urununun oldugunu assetr edin

           Assert.assertTrue(driver.findElement(linkTest).isDisplayed());


         sleep(5000);
         driver.quit();

    }
}