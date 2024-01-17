package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.test1.step;

import io.cucumber.java.en.Given;
import org.testng.Assert;

public class HooksSteps {
    @Given("hooks scenario {int} step {int}")
    public void hooksScenarioStep(int scenario, int steps) {
        System.out.println("Scenario: "+ scenario  +" steps :"+ steps);
       // Assert.assertTrue(steps<3); // negatif test yaptik.
    }
}
