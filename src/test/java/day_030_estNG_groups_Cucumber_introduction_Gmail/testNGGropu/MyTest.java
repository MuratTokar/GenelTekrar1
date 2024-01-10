package day_030_estNG_groups_Cucumber_introduction_Gmail.testNGGropu;

import org.testng.annotations.Test;

public class MyTest {

    @Test()
    public void test1(){
        System.out.println("test1");

    }
    @Test(groups = "A")
    public void test2(){
        System.out.println("test2");
    }
    @Test(groups = {"A","B"})
    public void test3(){
        System.out.println("test3");

    }
    @Test(groups = "B")
    public void test4(){
        System.out.println("test4");
    }
    @Test
    public void test5(){
        System.out.println("test5");
    }
}
