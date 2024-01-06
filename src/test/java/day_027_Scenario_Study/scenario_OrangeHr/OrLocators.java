package day_027_Scenario_Study.scenario_OrangeHr;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrLocators {
    WebDriver driver;
    public String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    @FindBy(xpath = "//input[@name=\"username\"]")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class=\"orangehrm-attendance-card-profile\"]")
    public WebElement loginAssert;

    @FindBy(xpath = "//span[text()='Admin']")
    public WebElement admin;

    @FindBy(xpath = "(//button[contains(@class,'oxd-button oxd')])[3]")
    public WebElement add;

    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    public WebElement userrolle;

    @FindBy(xpath = "//span[text()='ESS']")
    public WebElement ess;


    @FindBy(xpath = "(//div[text()='-- Select --'])[2]")
    public WebElement status;

    @FindBy(xpath = "//span[text()='Enabled']")
    public WebElement enabled;

    @FindBy(xpath = "(//input[@type='password'])[1]")
    public WebElement adPassword;

    @FindBy(xpath = "(//input[@type='password'])[2]")
    public WebElement confirmPassword;

    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    public WebElement employename;

    @FindBy(xpath = "//span[text()='Lisa  Andrews']")
    public WebElement lisa;

    @FindBy(xpath = "(//input[@class=\"oxd-input oxd-input--active\"])[2]")
    public WebElement addUsername;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement submitbutton;

    @FindBy(xpath = "(//i[@class=\"oxd-icon bi-trash\"])[26]")
    public WebElement lisaa;


    public OrLocators(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
