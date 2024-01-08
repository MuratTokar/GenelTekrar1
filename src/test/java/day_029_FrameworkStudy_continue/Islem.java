package day_029_FrameworkStudy_continue;

public class Islem {
    public static Islem islem(){
        return new Islem(0);
    }

    public static Islem islem(double num){
        return new Islem(num);
    }
    double sum;

    private Islem(double num){
        sum=num;
    }
    public Islem topla(double a){
        sum+=a;
        return  this;
    }
    public Islem cikar(double a){
        sum-=a;
        return  this;
    }
    public Islem carp(double a){
        sum*=a;
        return  this;
    }
    public Islem bol(double a){
        sum/=a;
        return this;
    }
    public void write(){
        System.out.println("sum= "+sum);
    }
}
