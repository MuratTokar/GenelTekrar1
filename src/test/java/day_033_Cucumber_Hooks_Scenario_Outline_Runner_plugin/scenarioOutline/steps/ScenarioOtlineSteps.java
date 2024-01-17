package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class ScenarioOtlineSteps {
    @Given("so scenario {int} setp {int}")
    public void soScenarioSetp(int scenario, int step) {
    }
    @When("so login with the following data")
    public void soLoginWithTheFollowingData(DataTable table) {
        Map<String,String> maps=table.asMap();
        System.out.println(maps.get("username"));
        System.out.println(maps.get("password"));


    }

    @Given("so my name is {string}")
    public void soMyNameIs(String name) {
        System.out.println("my name is  : " + name);
    }

    @When("so my age is {string}")
    public void soMyAgeIs(String age) {
        System.out.println("My age : " + age);
    }

    @Then("so my country is {string}")
    public void soMyCountryIs(String city) {
        System.out.println("my counry : " + city);
    }


}
