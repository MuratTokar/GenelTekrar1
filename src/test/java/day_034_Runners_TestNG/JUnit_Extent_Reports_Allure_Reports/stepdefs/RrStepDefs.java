package day_034_Runners_TestNG.JUnit_Extent_Reports_Allure_Reports.stepdefs;

import io.cucumber.java.en.Given;
import org.testng.Assert;

public class RrStepDefs {
    @Given("rr Scenario {int} Step {int}")
    public void rrScenarioStep(int scenario, int step) {
        System.out.println("Scenario : " + scenario + " ,step : " + step);
    }

    @Given("rr is {int} equals to {int}")
    public void rrIsEqualsTo(int num1, int num2) {
        Assert.assertEquals(num1,num2);
    }
}
