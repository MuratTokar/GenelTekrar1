package day_030_estNG_groups_Cucumber_introduction_Gmail.cucumber.definition1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepdefs1 {
    int sum;
    @Given("baslangic sayisi {int}")
    public void baslangicSayisi(int num) {
        sum=num;
    }

    @When("bu sayiya {int} eklendiginde")
    public void buSayiyaEklendiginde(int n) {
        sum+=n;

    }

    @Then("sonuc {int} olmali")
    public void sonucOlmali(int total) {
        Assert.assertEquals(sum,total);
    }

    @And("sonuc uygun")
    public void sonucUygun() {
        System.out.println("Metin");
    }

    @And("netice{string} olmali")
    public void neticeOlmali(String text) {
        System.out.println(text);
    }

}
