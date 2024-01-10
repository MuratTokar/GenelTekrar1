package day_030_estNG_groups_Cucumber_introduction_Gmail.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumberin feature, stepdefs,plugins gibi ozelliklerinin tanimlandigi yerdir
@CucumberOptions(
        // faturelerin yolu proje root undan itibaren alinir.ve proje icinde herhangi bir klasorde olabilir
        features = {"src/test/java/day_030_estNG_groups_Cucumber_introduction_Gmail/cucumber/MyFeature.feature"},
        //glue=steps<def.lerin yolu javadan itibaren alinir
        glue = {"day_030_estNG_groups_Cucumber_introduction_Gmail/cucumber/MyStepdefs1.java"}

)
public class Runner1 extends AbstractTestNGCucumberTests {
}
