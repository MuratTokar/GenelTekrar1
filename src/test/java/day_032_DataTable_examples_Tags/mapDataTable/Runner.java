package day_032_DataTable_examples_Tags.mapDataTable;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_032_DataTable_examples_Tags/mapDataTable/Map.feature"},
        glue = {"day_032_DataTable_examples_Tags/mapDataTable"}
)

public class Runner extends AbstractTestNGCucumberTests {
}
