package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline2.stepss;

import day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline2.pageObject.SdPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class Demostepss {
    SdPage sd=new SdPage();
    @Given("sd user navigate to homepage")
    public void sdUserNavigateToHomepage() {
        sd.gotopage();



    }

    @When("sd user try to login with the following credentials")
    public void sdUserTryToLoginWithTheFollowingCredentials(DataTable table) {
        Map<String,String> map=table.asMap();
        String username=map.get("username");
        String password=map.get("password");
        sd.sendkeys(sd.inputusername,username);
        sd.sendkeys(sd.inputPassword,password);
        sd.click2(sd.inputlogin);


    }

    @Then("login should be {string}")
    public void loginShouldBe(String result) {
        if (result.equalsIgnoreCase("true")){
            sd.waitforvisibity(sd.cartContainer);
        }else {
            sd.waitforvisibity(sd.errormessage);
        }
    }
}
