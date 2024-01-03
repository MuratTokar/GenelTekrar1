package day_025_Scenario_Example.demoblazetsts.tests;
import day_025_Scenario_Example.demoblazetsts.base.Basee;
import day_025_Scenario_Example.demoblazetsts.base.MyListener;
import day_025_Scenario_Example.demoblazetsts.locators.LOcators;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(MyListener.class)// tets te bir hata olunca screenshort almasi icin tets classinda @Listener(MyListener);
// actik icine MyListener clasi ile esitledik
public class Testt extends Basee {

    LOcators ls;

    @Test(priority = 1)
    public void TestGoto() {
        ls = new LOcators(driver);
        driver.get(ls.url);
        wait.until(ExpectedConditions.visibilityOf(ls.loginassert));


    }

    @Test(priority = 2 ,enabled = true)
    @Parameters({"username1", "password1"})
    public void TestRegister(String username, String password) {
        clickk(ls.registerButton);
        senkeys(ls.username, username);
        senkeys(ls.password, password);
        clickk(ls.singregister);
        wait.until(ExpectedConditions.alertIsPresent()).accept();
        wait.until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
        clickk(ls.close);


    }

    /**  ----> /** Enter yaptik
     * Bu metot aldigi username ve userpass ile login yapar
     * @param username
     * @param password
     */
    @Test(priority = 3,description = "bu test login yapar")// description ile aciklama ekledik
    @Parameters({"username1", "password1"})
    public void TestLogin(String username, String password) {
        clickk(ls.login);
        senkeys(ls.loginusername, username);
        senkeys(ls.loginpassword, password);
        clickk(ls.loginbutton);
        wait.until(ExpectedConditions.visibilityOf(ls.loginassert));


    }
}
