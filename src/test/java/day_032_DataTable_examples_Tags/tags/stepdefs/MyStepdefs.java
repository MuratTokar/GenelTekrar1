package day_032_DataTable_examples_Tags.tags.stepdefs;

import io.cucumber.java.en.Given;

public class MyStepdefs {
    @Given("tags scenario {int} step {int}")
    public void tagsScenarioStep(int scenario, int step) {
        System.out.println("Scenario:" + scenario + ", steo" + step);
    }


}
