package day_023_xml_introduction_parallelTest.Xml1;

import org.testng.annotations.*;

public class Testt {
    @BeforeSuite
    public void beforesuite(){
        System.out.println("beforesuite");
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
