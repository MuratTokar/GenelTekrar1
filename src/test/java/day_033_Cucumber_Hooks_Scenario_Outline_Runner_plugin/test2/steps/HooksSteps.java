package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.test2.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class HooksSteps {
    @Given("hooks scenario {int} step {int}")
    public void hooksScenarioStep(int scenario, int steps) {
        System.out.println("Scenario: "+ scenario  +" steps :"+ steps);
       // Assert.assertTrue(steps<3); // negatif test yaptik.
    }


}
