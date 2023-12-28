package day_021_FindAll_FindBys_HardAndSoftAssertion_Listeners.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardassert2 {
    @Test
    public void test1(){
        Assert.assertEquals(1,1);
        System.out.println("test1");

    }
    @Test
    public void test2(){
        Assert.assertTrue(false);
        System.out.println("test2");

    }
    @Test
    public void test3(){
        Assert.assertNull(null);
        System.out.println("test3");

    }
    @Test
    public void test4(){
        Assert.fail();
        System.out.println("fail");

    }
}
