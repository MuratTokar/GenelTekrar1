package day_020_POM.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;




public class  LoginPage extends Basepage{

   private String url="https://www.saucedemo.com/";

   private By lusername= By.id("user-name");
   private By lpasswort=By.id("password");
  private By lloginButton=By.id("login-button");
  private By laplogo=By.xpath("//div[text()='Swag Labs']");

    public LoginPage(WebDriver driver){
        super(driver);

    }
    public void gotoSite(){
        driver.get(url);
    }
    public void assertTitle(String title){
        Assert.assertEquals(driver.getTitle(),title);
    }

    public void login(String username,String password){
       sendkeys(lusername,username);
       sendkeys(lpasswort,password);
       click(lloginButton);
    }
    public ProductPage assertLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(laplogo));
        return new ProductPage(driver);
    }
}
