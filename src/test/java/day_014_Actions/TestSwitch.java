package day_014_Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.BaseClass;

import java.security.Key;
import java.util.List;
import java.util.Set;

public class TestSwitch extends BaseClass {
    /*
     * https://yahoo.com sayfasina gidin
     * cookileri kabul edin
     * searchbox a "guidersoft" yazin
     * guidersoft linkine tikla
     * Guidersoft sayfasinda  footer da bulunan "courses" linkine tiklayin
     * acilan sayfada kurs basliklarini  bir Arraylist e atin
     * yahoo sayfasina dönün
     * sayfayi kapatin
     * guidersoft sayfasina dönün
     * home linkine tiklayin,home sayfasina gittiginizi assert edin
     * driver i kapatin
     * */
    String url = "https://yahoo.com";
    By cookies = By.xpath("//button[text()='Alle akzeptieren']");
    By searchBox = By.xpath("//input[@id='ybar-sbq']");
    By guidersoftHome=By.xpath("//a[@aria-label='Home - Guider Soft']");
    By courses=By.xpath("//footer//a[text()='Courses']");
    By courseList=By.xpath("//h2[@class='course-title']//a");
    By home=By.xpath("//li[@id='menu-item-10545']//a[text()='Home']");

    @Test
    public void test1() {
        driver.manage().window().maximize();
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(cookies)).click();
        sendkeys(searchBox, "guidersoft", Keys.ENTER);

        String winYahoo=driver.getWindowHandle();

        wait.until(ExpectedConditions.visibilityOfElementLocated(guidersoftHome)).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); // yahoo ve guidersoft acilmali yani iki sayfa acik olmali


        Set<String> handels=driver.getWindowHandles(); // gelen handles ler yahoo nunkini icermemeli geri kalan zaten guidersoft un
        String guidersoftWin= driver.getWindowHandles()
                .stream()
                .filter(w-> !w.contains(winYahoo))
                .findFirst().get();
        driver.switchTo().window(guidersoftWin);// ustte acik olan iki window dan guidersoft a gonderdik
      jcScroll(700);

       wait.until(ExpectedConditions.visibilityOfElementLocated(courses));
       clickJc(courses);


        List<WebElement> lists=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(courseList));
        for (WebElement list : lists) {
            System.out.println(list.getText());
        }
        driver.switchTo().window(winYahoo);
        driver.close();
        driver.switchTo().window(guidersoftWin);
        wait.until(ExpectedConditions.visibilityOfElementLocated(home));
        clickJc(home);



          driver.quit();


    }
}
