package day_024_ParalelTest_ThreadLocalDriver;

public class VarragsArrays {
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        System.out.println(sum1(arr)); //array a deger gondermek zorundayiz

        System.out.println(sum2(1, 2, 3));
        System.out.println(sum2()); //Varrags deger gondermek zorunda degiliz
    }

    public static  int sum1(int[] arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];


        }
        return sum;

    }
    public static  int sum2(int...arr){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];


        }
        return sum;

    }
}
