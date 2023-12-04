package day_010_formElemets_checkbox_scroll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

import java.util.List;

public class CheckboxTest {
    /*
     * https://the-internet.herokuapp.com/checkboxes sayfasina gidin
     * her iki checkbox un value sini consola yazdirin
     * tikli olmayani tiklayin
     * her iki checkbox un valuesini consola yazdirin*/
    String url = "https://the-internet.herokuapp.com/checkboxes";
    WebDriver driver;
    By checkbox = By.xpath("//input[@type='checkbox']");
    By check = By.xpath(" //input[@type='checkbox'][1]");

    By select = By.xpath("//select[@id='dropdown']");

    By playgrund=By.cssSelector("#newButtonName");

    By button=By.cssSelector("#updatingButton");
    By assertn=By.xpath("//button[text()='Murat']");

    public CheckboxTest() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();


    }

    @Test
    public void test1() {
        driver.get(url);
        List<WebElement> element = driver.findElements(checkbox);
        for (WebElement webElement : element) {
            System.out.println(webElement.getAttribute("value"));

        }
        // click(check); // click ettik

        List<WebElement> elements = driver.findElements(checkbox);
        for (WebElement el : elements) {
            System.out.println(el.getAttribute("checked"));

        }

        System.out.println("**********************");
        for (WebElement el : elements) {
            if (el.getAttribute("checked") == null) // boylede click edilir.
                el.click();

        }


    }

    @Test
    public void test2() {

        String url = "https://the-internet.herokuapp.com/dropdown";
        driver.get(url);//  https://the-internet.herokuapp.com/dropdown adresine gidin
        WebElement element = driver.findElement(select);
        Select select1 = new Select(element);
        for (WebElement option : select1.getOptions()) {
            System.out.println(option.getText()); //dropdown opsiyonlarinin textlerini yazdirin

        }
        WebElement element1 = driver.findElement(select);
        Select select2 = new Select(element1);
        select2.selectByIndex(1);    //siradan tum optionlari 1 sn ara vererek secin
        sleep(2000);
        select2.selectByIndex(2);    //siradan tum optionlari 1 sn ara vererek secin
        sleep(2000);
        select2.selectByValue("1"); //value degeri 1 olani secin
        sleep(2000);
        select2.selectByVisibleText("Option 2");// visible text i option 2 olani secin

        // yada for ile     //siradan tum optionlari 1 sn ara vererek seceriz
        for (int i = 0; i < select2.getOptions().size(); i++) {
            if (select2.getOptions().get(i).getAttribute("disabled")==null)
                select2.selectByIndex(i);



        }
        utils.Driver.quit();


    }
    @Test
    public void test3(){
        String url="http://uitestingplayground.com/textinput";
        
        driver.get(url);//"http://uitestingplayground.com/textinput"
        sendkeys(playgrund,"Murat");// isminizi yazin
        click(button); // submit buton tikla
       // Assert.assertTrue(driver.findElement(assertn).getText().equalsIgnoreCase("Murat"));// isminizin gorundugunu assert edin
        Assert.assertTrue(driver.findElement(assertn).isDisplayed());//isminizin gorundugunu assert edin
        driver.quit();
    }






    public void click(By locator) {
        driver.findElement(locator).click();


    }
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void sendkeys(By locator,String text){
        driver.findElement(locator).sendKeys(text);};

}

