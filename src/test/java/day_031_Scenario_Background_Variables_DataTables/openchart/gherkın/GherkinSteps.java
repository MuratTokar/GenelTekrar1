package day_031_Scenario_Background_Variables_DataTables.openchart.gherkın;

import io.cucumber.java.en.Given;

public class GherkinSteps {
    @Given("{string} nin kilosu {int} Tl")
    public void ninKilosuTl(String arg0, int arg1) {
        System.out.println("1: " + arg0 + " , " + arg1);
    }

    @Given("{string} fiyati {double} Tl")
    public void fiyatiTl(String arg0, double arg1) {
        System.out.println("2: " + arg0 + " , " + arg1);
    }

    @Given("Türkiyenin baskenti{string} dir")
    public void türkiyeninBaskentiDir(String metin) {
        System.out.println("3:" + metin);
    }

    @Given("Sayilarimiz {int}, {int}, {int}, {int}, {int} olsun")
    public void sayilarimizOlsun(int arg0, int arg1, int arg2, int arg3, int arg4) {
        System.out.println("4:" + arg0 + "," + arg1+ "," + arg2 +"," + arg3 + "," + arg4);
    }
}
