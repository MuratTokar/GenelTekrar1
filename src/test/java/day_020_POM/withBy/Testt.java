package day_020_POM.withBy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.util.List;

public class Testt {
    WebDriver driver;
    LoginPage lp;
    ProductPage pp;
    @BeforeTest
    public void beforetest(){
        driver= Driver.getDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void test1(){
        lp=new LoginPage(driver);
        lp.gotoSite();
        lp.assertTitle("Swag Labs");
        lp.login("standard_user","secret_sauce");
        pp=lp.assertLogin();

    }
    @Test(dependsOnMethods = {"test1"})
    public void testproduct(){
      //  pp=new ProductPage(driver);
        List<String> names=pp.getlistOfProductsname();
        System.out.println(names);

    }
    @AfterTest
    public void tearDown(){
        Driver.quit();
    }
}
