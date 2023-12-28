package day_020_POM.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends Basepage{
    By products=By.xpath("//div[@class='inventory_item']");
    By productname=By.xpath("//div[@class='inventory_item_name ']");
    By productprice=By.xpath("//div[@class='inventory_item_price']");
    By addtocart=By.xpath("//button[text()='Add to cart']");


    public ProductPage(WebDriver driver){
        super(driver);

    }
    public List<String> getlistOfProductsname(){
        return driver.findElements(productname)
                .stream().map(element -> element.getText())
                .collect(Collectors.toList());


        }

    }

