package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.scenarioOutline2.pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SdPage extends SdBaseTest {
    final String url = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    public WebElement inputusername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "login-button")
    public WebElement inputlogin;

    @FindBy(id = "shopping_cart_container")
    public WebElement cartContainer;
    @FindBy(xpath = "//h3[@data-test=\"error\"]")
    public WebElement errormessage;

    public void gotopage() {
        driver.get(url);
    }


}
