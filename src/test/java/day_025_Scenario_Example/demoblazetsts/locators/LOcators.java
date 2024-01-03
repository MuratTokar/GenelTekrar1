package day_025_Scenario_Example.demoblazetsts.locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LOcators {
    WebDriver driver;
   public String url="https://demoblaze.com";

   @FindBy(xpath = "//a[@id=\"nava\"]//img")
   public WebElement loginassert;

   @FindBy(css = "#signin2")
   public WebElement registerButton;

   @FindBy(css = "#sign-username")
   public WebElement username;

   @FindBy(css = "#sign-password")
   public WebElement password;

   @FindBy(xpath = "//button[text()='Sign up']")
   public WebElement singregister;

   @FindBy(xpath = "(//button[text()='Close'])[2]")
   public WebElement close;

   @FindBy(css = "#login2")
   public WebElement login;

   @FindBy(css = "#loginusername")
   public WebElement loginusername;

   @FindBy(css = "#loginpassword")
    public WebElement loginpassword;

   @FindBy(xpath = "//button[text()='Log in']")
   public WebElement loginbutton;

   @FindBy(css = "#nameofuser")
   public WebElement loginassertt;




    public  LOcators(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
}
