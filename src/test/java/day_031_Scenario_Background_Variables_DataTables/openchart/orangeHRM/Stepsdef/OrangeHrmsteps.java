package day_031_Scenario_Background_Variables_DataTables.openchart.orangeHRM.Stepsdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseClass;
import utils.Driver;

import java.time.Duration;
import java.util.Map;

public class OrangeHrmsteps{
    String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By lusername=By.xpath("//input[@name=\"username\"]");
    By lpassword=By.xpath("//input[@name=\"password\"]");
    By lloginbutton=By.xpath("//button[@type=\"submit\"]");
    By ldascboard=By.xpath("//h6[text()='Dashboard']");
    WebDriver driver;
    WebDriverWait wait;

    {
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Given("user on page")
    public void userOnPage() {
        driver.get(url);
    }

    @When("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        Map<String ,String> map=table.asMap();
        String username=map.get("username");
        String password=map.get("password");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lusername)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpassword)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(lloginbutton)).click();


    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ldascboard));
    }
}
