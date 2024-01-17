package day_033_Cucumber_Hooks_Scenario_Outline_Runner_plugin.test1.step;

import io.cucumber.java.*;

public class Hooks {
    // Hooks un calismasi icin stepdefs paketinde yani glue de olmali
    @BeforeAll // cucumberde ilk calisacak metotdur ve metot static olmali
    public static void beforeAll() {
        System.out.println("Beforeall");

    }

    @Before("@regression") // Her senaryo oncesi calisir. static olmak zorunda degil.once kucuk olan claisr.burda
    // hangi anotation u calistiracaginida yazabilirz
    public void before1() {
        System.out.println("before1");

    }

    @BeforeStep // step oncesi calisir
    public void beforestep(){
        System.out.println("beforestep");
    }

    @AfterStep
    public void afterstep(){
        System.out.println("afterstep");
    }

    @Before(order = 2)// istedigimiz kadar before ekleyebiliz .Calisma siralamasini order ile veririrz
    public void before2() {
        System.out.println("before2");

    }

    @After(order = 1)  // her senaryo sonrasi calisir.static olmak zorunda degil.once buyuk olan calisir
    public void after1() {
        System.out.println("after1");

    }

    @After("@regression") // her senaryo sonrasi calisir.static olmak zorunda degil
    public void after2() {
        System.out.println("after2");
    }

    @AfterAll  // cucumberde en son calisacak metottur.static olmak zorunda
    public static void afterAll() {
        System.out.println("Afterall");

    }

}