package day_010_formElemets_checkbox_scroll;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

public class ButtonTest extends BaseClass{

    By playgrund=By.cssSelector("#newButtonName");

    By button=By.cssSelector("#updatingButton");
   // String tex = RandomStringUtils.randomAlphabetic(5, 10);


    @Test
    public void buttonClickWithJc(){
        String url="https://uitestingplayground.com/textinput";
        driver=Driver.getDriver();
        driver.get(url);

        for (int i = 0; i < 5; i++) {


           jcScroll(-200);
           sleep(2000);
        }
        driver.quit();
    }

}
