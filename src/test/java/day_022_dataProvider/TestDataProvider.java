package day_022_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + ",");

        }
    }
    // test methoduna data nasil aktarilir
    // 1.DataProvider dir

    @Test(dataProvider = "data1")
    public void test1(int i) {
        System.out.println(i);

    }

    // DataProvider object[][] return etmeli
    @DataProvider
    public Object[][] data1() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };


    }

    @Test(dataProvider = "MyData3")
    public void test3(String name, int i) {
        System.out.println(name + ":" + i);

    }

    // DataProvider object[][] return etmeli
    @DataProvider(name = "MyData3")
    public Object[][] data3() {
        return new Object[][]{
                {"Ali", 1},
                {"Veli", 2},
                {"Deniz", 5}

        };


    }

    @Test(dataProvider = "MyData4")                 // ustteki ile ayni,
    public void test4(Object[] arr) {
        System.out.println(arr[0] + ":" + arr[1]);

    }

    // DataProvider object[][] return etmeli
    @DataProvider(name = "MyData4")
    public Object[][] data4() {
        return new Object[][]{
                {"Ali", 1},
                {"Veli", 2},
                {"Deniz", 5}

        };

    }
}
