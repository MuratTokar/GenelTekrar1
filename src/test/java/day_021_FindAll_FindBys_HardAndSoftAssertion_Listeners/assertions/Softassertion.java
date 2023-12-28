package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.assertions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Softassertion {
    //assertler test sonunda yapilsin ve en sonrda @AfterTestte softAssert.assertAll();
    SoftAssert softAssert;

    @BeforeTest
    public void beforetest(){
        softAssert=new SoftAssert();

    }
    @AfterTest
    public void aftertest(){
        softAssert.assertAll(); // burda en son assert olacak

    }
    @Test
    public void test1(){
        softAssert.assertEquals(1,1);
        System.out.println("test1");

    }
    @Test
    public void test2(){
        softAssert.assertTrue(false);
        System.out.println("test2");

    }
    @Test
    public void test3(){
        softAssert.assertNull(null);
        System.out.println("test3");

    }

}
