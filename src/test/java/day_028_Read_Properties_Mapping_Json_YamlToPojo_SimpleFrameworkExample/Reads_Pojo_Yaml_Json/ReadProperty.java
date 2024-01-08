package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.Reads_Pojo_Yaml_Json;

import org.testng.annotations.Test;
import utils.BaseClass;
import utils.Driver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ReadProperty extends BaseClass {

    @Test
    public void propertyFile1() {
        // System.getProperties().forEach((k,v)-> System.out.println(k+":"+v));  //sistemin özelliklerini veriyor

        Properties properties = new Properties(); //properties doyyasi  key ve value den olusur yani karsilikli deger vardir
        properties.setProperty("url", "https://google.com");
        properties.setProperty("a", "b");

        System.out.println("properties.getProperty(\"url\") = " + properties.getProperty("url"));
        System.out.println("properties.getProperty(\"a\") = " + properties.getProperty("a"));

        properties.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    @Test
    public void testReaderPropertyFromFile() throws IOException {
        driver= Driver.getDriver();

        // properties oludturdur
        Properties properties = new Properties(); // ramda olustu
        // okuyucu olusturdur ve properties filenin path ini yapistirdik ve bu file yi oku dedik
        FileReader file = new FileReader("src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/myProp1.properties");
        // okunan file yi properties e yukledik
        properties.load(file);

        // String url=properties.getProperty("oranghrm.url");   // url yi alip yazdik
        //  System.out.println(url);
        properties.forEach((k, v) -> System.out.println(k + ":" + v));
        driver.get(properties.getProperty("oranghrm.url"));
        sleep(3000);

        driver.get(properties.getProperty("demoblaze.url"));

        sleep(3000);
        driver.quit();

    }
    @Test
    public void testReaderWritePropertyFromFile() throws IOException {
        Properties properties = new Properties();

        String filepath="src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/myProp1.properties";
        FileReader file = new FileReader(filepath);
        properties.load(file);

        System.out.println("Property File content");
        properties.forEach((k, v) -> System.out.println(k + ":" + v));

       // properties.setProperty("oranghrm.user","admin1");// properties file deki oranghrm user i admin1 yaptik
       // properties.setProperty("newKey","newValue");

        properties.setProperty("oranghrm.user","Admin");// properties file deki yapilan degisikligi tekrar degistik
        properties.remove("newKey"); // new key i sildik


        System.out.println("Property File content"); // ekrana yazdiriyoruz
        properties.forEach((k, v) -> System.out.println(k + ":" + v));

        // burda yazdirmak icin de FileWriter objesi olusturacagiz ve boylece file dosyasindaki
        //oranghrm.user =admin1 oldu
        FileWriter writer=new FileWriter(filepath); // filepath in ustune yazdiracagiz
        properties.store(writer,"Aciklama");




    }
}
