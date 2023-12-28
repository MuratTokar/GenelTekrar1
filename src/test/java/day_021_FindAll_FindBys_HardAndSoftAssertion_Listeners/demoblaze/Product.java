package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.demoblaze;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.openqa.selenium.WebElement;
@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {
   private  WebElement link;
   private String name;
   private int prince;
   private String description;
}
