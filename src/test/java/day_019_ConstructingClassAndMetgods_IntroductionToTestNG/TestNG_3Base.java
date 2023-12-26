package day_019_ConstructingClassAndMetgods_IntroductionToTestNG;

import org.testng.annotations.*;

public class TestNG_3Base {

    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("aftertest");
    }
    @BeforeClass
    public void beforeclass(){
        System.out.println("beforeclass");
    }
    @AfterClass
    public void afterclass(){
        System.out.println("afterclass");
    }
    @BeforeMethod
    public void beforeMetot(){
        System.out.println("before metot");

    }
    @AfterMethod
    public void aftermetot(){
        System.out.println("Aftermetot");
    }
}
