package day_032_DataTable_examples_Tags.mapDataTable;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class Mapsteps {
    List<String> citiess;
    List<List<String>> allCitiess;
    int count;

    @Given("my string is as fallows")
    public void myStringIsAsFallows(DataTable table) {
        citiess = table.asList();
    }

    @When("my data is as follows")
    public void myDataIsAsFollows(DataTable table) {
        allCitiess = table.asLists();
    }

    @Then("the count of the cities are {int}")
    public void theCountOfTheCitiesAre(int num) {
        for (String city : citiess) {
            for (List<String> allcity : allCitiess) {
                for (String s : allcity) {
                    if (s.equalsIgnoreCase(city)) {
                        count++;
                    }

                }

            }

        }
        Assert.assertEquals(count, num);
    }
}
