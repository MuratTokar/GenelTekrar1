package day_032_DataTable_examples_Tags.listdataTables;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class DataTableSteps {
    int num;

    @Given("initial value is {int}")
    public void initialValueIs(int value) {
        num = value;
    }

    @When("user add the following numbers")
    public void userAddTheFollowingNumbers(DataTable table) {
        List<Integer> list = table.asList(Integer.class);
        list.forEach(e -> num += e);
    }

    @Then("sum should be {int}")
    public void sumShouldBe(int sum) {
        Assert.assertEquals(num, sum);

    }
}
