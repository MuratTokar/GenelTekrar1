package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.listeners;
import org.testng.annotations.*;
@Listeners(MyListener.class)

public class Testlistener {
    @BeforeSuite
    public void beforsuite(){
        System.out.println("Beforsuite");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("aftersuite");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("aftertest");
    }
    @Test
    public void test1(){

        System.out.println("test1");

    }
    @Test
    public void test2(){

        System.out.println("test2");

    }
    @Test
    public void test3(){

        System.out.println("test3");

    }

}
