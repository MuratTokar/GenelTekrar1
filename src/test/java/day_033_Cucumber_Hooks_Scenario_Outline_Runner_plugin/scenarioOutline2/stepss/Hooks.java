package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline2.stepss;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;

public class Hooks {
    @Before
    public void before(){
        Driver.getDriver();
    }
    @After
    public void after(){
        Driver.quit();
    }
}
