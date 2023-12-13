package day_014_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;


import java.time.Duration;
import java.util.List;

public class Actionss extends BaseClass {
    String url = "https://opencart.abstracta.us/";
    By drop = By.xpath("//a[text()='Desktops']");
    By drops = By.xpath("//ul[@class='nav navbar-nav']/li");

    @Test
    public void actions() {
        driver.manage().window().maximize();
        driver.get(url);
        WebElement element = driver.findElement(drop);
        hover(element);


       /* Actions ac=new Actions(driver);
        ac.moveToElement(element)
                .pause(10)
                .build()
                .perform();*/
        driver.quit();


    }

    @Test
    public void actions2() { // dorpdown menuleri dolasiyor
        driver.manage().window().maximize();
        driver.get(url);


        List<WebElement> lists = driver.findElements(drops);

        for (WebElement lists1 : lists) {
            hover(lists1);

        }
        driver.quit();
    }


    @Test
    public void actionsHoverMain3() {
        driver.manage().window().maximize();
        driver.get(url);


        List<WebElement> lists = driver.findElements(drops);
        for (WebElement lists1 : lists) {
            hover(lists1);
            By sublist = By.xpath(".//ul/li");// nokta sadece ana menunun altinda aramak
            // icin yazdik.yoksa bastan alirdi.yni aktif elemntten ara.aktif menuun altinda
            List<WebElement> submneu = lists1.findElements(sublist);
            if (submneu.size() > 0) {
                for (WebElement subEl : submneu) {
                    new Actions(driver).moveToElement(subEl).pause(100).perform();

                }
            }
        }
        driver.quit();
    }

    @Test
    public void mouse_over() {
        By mouser = By.xpath("//div[@class='figure text-center col-3 py-2']");
        By captions = By.xpath("//div[@class='caption']");
        String url = "https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
        driver.manage().window().maximize();
        driver.get(url);
        ;
        List<WebElement> listst = driver.findElements(mouser);
        for (WebElement list1 : listst) {
            hover(list1);
            WebElement capt = list1.findElement(captions);

            // wait.until(ExpectedConditions.visibilityOf(capt));

        }

    }

    /*
    Actions actions=new Actions(driver);
    actions.moveToElement();
    actions.clickAndHold();
    actions.click();
    actions.pause();
    actions.dragAndDrop();
    actions.dragAndDropBy();
    actions.sendKeys();
    actions.keyDown();
    actions.keyUp();
    actions.doubleClick();
    actions.contextClick();
    actions.moveByOffset();
    actions.scrollByAmount();
    actions.scrollToElement();
       */
    @Test
    public void drag_drop() {

        String url = "https://testpages.herokuapp.com/styled/drag-drop-javascript.html";
        By dragTable2 = By.cssSelector("#draggable2");
        By dropHere = By.cssSelector("#droppable1");

        By dragTable1 = By.cssSelector("#draggable1");
        By nodropHere = By.cssSelector("#droppable2");

        driver.manage().window().maximize();
        driver.get(url);
        WebElement draggable2 = driver.findElement(dragTable2);
        WebElement droppable1 = driver.findElement(dropHere);

        WebElement draggable1 = driver.findElement(dragTable1);
        WebElement droppable2 = driver.findElement(nodropHere);

        new Actions(driver)
                .clickAndHold(draggable2)
                .moveToElement(droppable1)
                .release()
                .pause(300)
                .clickAndHold(draggable1)
                .moveToElement(droppable2)
                .release()
                .perform();

        driver.quit();
    }
}


