package day_012_waits_alerts;

import org.openqa.selenium.By;

public class AlertsLocators {
  public static final String URL="https://demoqa.com/alerts";
    static By alertsButton=By.cssSelector("#alertButton");
    static By timerAlertButton=By.cssSelector("#timerAlertButton");
    static By confirmButton=By.cssSelector("#confirmButton");
    static By confirmResult=By.cssSelector("#confirmResult");
    static By promtButton=By.cssSelector("#promtButton");
    static By promptResult=By.cssSelector("#promptResult");
}
