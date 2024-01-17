package day_032_DataTable_examples_Tags.sauceDemo;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_032_DataTable_examples_Tags/sauceDemo/Saucedemo.feature"},
        glue = {"day_032_DataTable_examples_Tags/sauceDemo","day_031_Scenario_Background_Variables_DataTables.openchart.stepdefs"}
        // eger farkli yerlerde stepdef ler varsa burda runnerde belirtmemiz lazim.
        //cunku bu steps " Given user navigate to "https://www.saucedemo.com/" baska gun icindeydi ve step yazarken otomatik geldi
        // glude nereyi gostersek oraya bakar.Driver i ise ilk stepsin runn edildigi onceki gunde aldi
)

public class Runner extends AbstractTestNGCucumberTests {
}
