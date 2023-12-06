package day_013_iframe_window_switchTo;

import org.testng.annotations.Test;
import utils.BaseClass;

public class SystemProperties extends BaseClass {
    public static void main(String[] args) {
        System.getProperties().forEach((k,v)-> System.out.println(k + ":" + v));

    }

}
