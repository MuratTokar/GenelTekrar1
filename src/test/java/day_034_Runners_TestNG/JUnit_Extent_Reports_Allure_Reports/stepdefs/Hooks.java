package day_034_Runners_TestNG.JUnit_Extent_Reports_Allure_Reports.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

import java.io.File;

public class Hooks {
    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()){
            scenario.log(scenario.getName() + "failled");
           // TakesScreenshot ss= (TakesScreenshot) Driver.getDriver();
           // byte[] resim=ss.getScreenshotAs(OutputType.BYTES);
          //  scenario.attach(resim,"image/png","Hata Resmi");




        }
    }
}
