package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.test2.steps;

import io.cucumber.java.*;

public class Hooks {

    @Before
    public void before1(Scenario scenario) {
        System.out.println("scenario.getName() = " + scenario.getName());

    }

    @BeforeStep
    public void beforestep(Scenario scenario){
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
    }

    @AfterStep
    public void afterstep(Scenario scenario){
        System.out.println("scenario.getUri() = " + scenario.getUri());
    }


    @After
    public void after1(Scenario scenario) { // senaryo ile ilgili bilgileri yakalamak icin
        System.out.println("scenario.getLine() = " + scenario.getLine());
        System.out.println("scenario.isFailed() = " + scenario.isFailed());
      //  if (scenario.isFailed()){

      //  }
        // MESELA BURDA SENAYRYO FAIL ISE EKRAN GORUNTUSU ALABILIRIZ


    }

}