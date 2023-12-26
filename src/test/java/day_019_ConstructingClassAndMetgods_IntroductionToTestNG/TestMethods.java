package day_019_ConstructingClassAndMetgods_IntroductionToTestNG;

public class TestMethods {
    public static void main(String[] args) {
        Methods methods=new Methods(Browsers.Chrome);
        methods.get("https://www.google.com");
        methods.driver.quit();

    }
}
