package day_029_FrameworkStudy_continue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Driver;

import static day_029_FrameworkStudy_continue.MyElement.*;

public class MyElementTest {
    String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By lusername= By.cssSelector("//input[name='username']");
    By lpassword= By.cssSelector("//input[name='password']");
    By lloginbutton= By.xpath("//button[contains(.,'Login')]");
    @Test
    public void test1(){
        Driver.getDriver().get(url);
        $(lusername)
                .shouldBe(Conditions.visible).sendkeys("Admin");
        $(lpassword)
                .sendkeys("admin123");
        $(lloginbutton)
                .shouldBe(Conditions.clickable).click();

    }
}
