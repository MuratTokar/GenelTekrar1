package day_032_DataTable_examples_Tags.listdataTables;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_032_DataTable_examples_Tags/dataTables/Datatables.feature"},
        glue = {"day_032_DataTable_examples_Tags/listdataTables"}
)

public class Runner extends AbstractTestNGCucumberTests {
}
