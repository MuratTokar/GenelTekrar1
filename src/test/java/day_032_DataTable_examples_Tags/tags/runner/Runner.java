package day_032_DataTable_examples_Tags.tags.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_032_DataTable_examples_Tags/tags/feature/Tags.feature"},
        glue = {"day_032_DataTable_examples_Tags/tags/stepdefs"},
        tags = "@smoke"
)

public class Runner extends AbstractTestNGCucumberTests {
}
