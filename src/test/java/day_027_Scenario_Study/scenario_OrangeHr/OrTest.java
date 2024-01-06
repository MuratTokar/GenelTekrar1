package day_027_Scenario_Study.scenario_OrangeHr;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class OrTest extends OrBase {


    OrLocators ort;

    @Test(dataProvider = "loginData", priority = 1)
    public void LoginTest(String usernamee, String passwordd) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ort = new OrLocators(driver);
        driver.get(ort.url);
        sendkeys(ort.username, usernamee);
        sendkeys(ort.password, passwordd);
        click(ort.loginButton);
        wait.until(ExpectedConditions.visibilityOf(ort.loginAssert));

    }

    @Test(priority = 2)
    public void testClick() {
        click(ort.admin);
        click(ort.add);

    }

    @Test(dataProvider = "formData", priority = 3)
    public void addUserForm(String user, String pass) {
        click(ort.status);
        click(ort.enabled);
        click(ort.userrolle);
        click(ort.ess);  //
        sendkeys(ort.employename, "Lisa");
        click(ort.lisa);
        sendkeys(ort.addUsername, user);
        sendkeys(ort.adPassword, pass);
        sendkeys(ort.confirmPassword, "mrt25061985");
        click(ort.submitbutton);
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        jcscroll("300");
        //click(ort.lisa);


        // burada userrolle once clik edilince  status kodu siliniyor ve locator bulunmuyor.
        // bu nedenle once ikici sonra birinci click ettik

    }

    @DataProvider(name = "loginData")
    public Object[][] getdata() {
        return new Object[][]{
                {"Admin", "admin123"},


        };
    }

    @DataProvider(name = "formData")
    public Object[][] dataGet() {
        return new Object[][]{
                {"Mahmut", "mrt25061985"},


        };
    }


}
