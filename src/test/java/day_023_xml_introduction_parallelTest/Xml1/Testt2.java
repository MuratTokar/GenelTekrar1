package day_023_xml_introduction_parallelTest.Xml1;

import org.testng.annotations.*;

public class Testt2 {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("beforesuite2");
    }
    @AfterSuite
    public void aftersuite(){
        System.out.println("aftersuite2");
    }
    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest2");
    }
    @AfterTest
    public void aftertest(){
        System.out.println("aftertest2");
    }
    @Test
    public void test1(){
        System.out.println("test12");
    }
    @Test
    public void test2(){
        System.out.println("test22");
    }
    @Test
    public void test3(){
        System.out.println("test32");
    }
}
