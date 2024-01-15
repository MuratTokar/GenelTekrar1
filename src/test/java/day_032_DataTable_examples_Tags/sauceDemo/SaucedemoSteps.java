package day_032_DataTable_examples_Tags.sauceDemo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;

public class SaucedemoSteps {
    By lusername=By.cssSelector("#user-name");
    By lpassword=By.cssSelector("#password");
    By lloginbutton=By.cssSelector("#login-button");
    By product=By.xpath("//span[text()='Products']");

    WebDriver driver;
    WebDriverWait wait;
    public SaucedemoSteps(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @When("user input username as {string}")
    public void userInputUsernameAs(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lusername)).sendKeys(username);
    }

    @And("user input password as {string}")
    public void userInputPasswordAs(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpassword)).sendKeys(password);
    }

    @And("user click to login button")
    public void userClickToLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(lloginbutton)).click();
    }

    @Then("login schould be successful")
    public void loginSchouldBeSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(product));

    }


}
