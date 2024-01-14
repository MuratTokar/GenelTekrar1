package day_031_Scenario_Background_Variables_DataTables.openchart.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;

public class StepdefsOpencart {
    WebDriver driver;
    WebDriverWait wait;
    By search=By.xpath("//input[@name=\"search\"]");
    By searchHeader=By.xpath("//h2[text()='Search']");
    By products=By.xpath("//div[@class=\"product-thumb\"]");

    {
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @Given("user navigate to {string}")
    public void userNavigateTo(String url) {
        driver.get(url);
    }

    @When("user search for {string}")
    public void userSearchFor(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search)).sendKeys(text, Keys.ENTER);
    }

    @Then("listed product number should be {int}")
    public void listedProductNumberShouldBe(int product) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHeader));
      //  wait.until(ExpectedConditions.titleContains("Search")); yada title search icerene kadar beklesin
        int listelenenUrun=driver.findElements(products).size();
        Assert.assertEquals(listelenenUrun,product);
    }
}
