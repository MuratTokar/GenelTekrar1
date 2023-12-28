package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardassert {

    // Hard assertion assert yapildiginda hata olursa test orada kesilir
    //Assert.assertTrue(flse);
    @Test
    public void testAssertion(){
        int a=2;
       // Assert.assertEquals(a,2);
       Assert.assertEquals(a,2,a + " sayisi 2 ye esit degil ");


    }
    @Test
    public void assertTrue(){
        int num=4;
        int num1=3;
        Assert.assertTrue(num<num1,num + "," + num1 + " den kücük degil");
    }
    @Test
    public void assertFalse(){
        int num=4;
        int num1=3;
        Assert.assertFalse(num<num1,num + "," + num1 + " den büyük");
    }
}
