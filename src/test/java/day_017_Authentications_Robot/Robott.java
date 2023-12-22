package day_017_Authentications_Robot;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Robott {

    @Test
    public void robotClass() throws AWTException {
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL); // ctrl tusuna basar
        robot.keyRelease(KeyEvent.VK_CONTROL); // ctrl tusunu birak
        robot.keyPress(KeyEvent.VK_A);//a buraya a yazdi.aktif oldugu yerde islem yapar
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('x'));//ax burda aktif oldugu icin buraya yazdi
       // axguidersoft  buraya yazdi
        write("Guidersoft");
        write("murat");


    }


    public void write(String str) throws AWTException {
        Robot robot=new Robot();
        for (int i = 0; i <str.length(); i++) {
       robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));
        }
    }
}
