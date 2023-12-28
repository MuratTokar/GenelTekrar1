package day_020_POM.testNg;

import org.openqa.selenium.By;

public enum Locators {

    // enum public final dir otomatik

    Google_Accept_Cookie(By.xpath("//div[text()='Tümünü kabul et']")),
    Searc_Button(By.xpath("//textarea[@id=\"APjFqb\"]"));

    private By locator;

    Locators(By locator){
        this.locator=locator;

    }
    public By getLocator(){
        return locator;
    }
}
