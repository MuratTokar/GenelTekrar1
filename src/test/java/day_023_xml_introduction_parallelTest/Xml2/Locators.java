package day_023_xml_introduction_parallelTest.Xml2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Locators {
    String url="https://demoblaze.com/";
    @FindBy(xpath = "//a[text()='Phones']")
    WebElement phoneslink;

    @FindBy(css = ".card-title>a")
   List<WebElement> productsNameList;

/*
    //FindAll icindeki8 @findby lar ile belirtilen tum elementleri
    //ayri ayri bulur
    @FindAll({
            @FindBy(css = " "),
            @FindBy(xpath = " ")
   } )
            List<WebElement> elements;

    // birinin altinda digerini arar
    @FindBys({
            @FindBy(css = ""),
            @FindBy(css = "")
    })
        List<WebElement> elements;*/

    @FindBy(css = "#tbodyid>div")
            List<WebElement> productss;

    WebDriver driver;

    public Locators(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
