package day_034_Runners_TestNG.JUnit_Extent_Reports_Allure_Reports.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day_034_Runners_TestNG/JUnit_Extent_Reports_Allure_Reports/features/Feature34.feature"},
        glue = {"day_034_Runners_TestNG/JUnit_Extent_Reports_Allure_Reports/stepdefs"},
         //  tags = "@smok",
         //".*smoke:" smoke ile biten
         // "smoke.*": smoke ile baslayan
         //".*smoke.*" : smoke iceren
        monochrome = true, // ayni renk yapar
        name = {"Scenario 1"}, // ismi senaryo 1 olani run eder.senaryo ismine gore,virgul ile senaryo 2 de ekleyebiliz
      //  dryRun = true, // bur tum steplerin olup olmadigina bakar
        publish = true, // raporlari direk cucumber sayfasina gonderir ve 1 gunlugune ulasılır
        plugin = {"pretty",
                "html:target/cucumber/cucumber.html" , // basit bir rapor
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }

)

public class Runner extends AbstractTestNGCucumberTests {
}
