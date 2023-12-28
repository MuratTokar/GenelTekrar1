package day_020_POM.withfindBy;

import day_020_POM.withBy.Basepage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class LoginPagee extends Basepage {

    private String url = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    private WebElement eusername;

    @FindBy(id = "password")
    private WebElement epassword;

    @FindBy(id ="login-button")
    private WebElement eloginbutton;

   @FindBy(xpath ="//div[text()='Swag Labs']")
   private WebElement elaplogo;


    public LoginPagee(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);// bu initialize olmazsa element olusturulamaz

    }

    public void gotoSite() {
        driver.get(url);
    }

    public void assertTitle(String title) {
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void login(String username, String password) {
       eusername.sendKeys(username);
        epassword.sendKeys(password);
        eloginbutton.click();
    }

    public void assertLogin() {
         wait.until(ExpectedConditions.visibilityOf(elaplogo));

    }
}
