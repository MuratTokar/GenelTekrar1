package day_023_xml_introduction_parallelTest.Xml4;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCount {
    /*

    * BeforeTest(strıng testname)
    * Test1(ınt num) 0 dan numa kadar for ıle saysın
    * Test2(int num) 0 dan numa kadar toplasin
    * num xml den gelsin
    * xml icin de  test1
    *           test1 ve     test2
                     test3 olsun ve paralel calissin*/

    @BeforeTest
    @Parameters({"testname"})
    public void beforetest(String testname){
        System.out.println(Thread.currentThread().getName() + " : " + testname);

    }
    @Test
    @Parameters({"num"})
    public void test1(int num){
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName() + " : " +i);

        }

    }
    @Test
    @Parameters({"num1"})
    public void test2(int num){
        int top=0;
        for (int i = 0; i <num; i++) {
            top+=i;


        }
        System.out.println(Thread.currentThread().getName() + " : " + top);

    }
}
