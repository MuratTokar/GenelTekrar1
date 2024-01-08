package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.Reads_Pojo_Yaml_Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.Reads_Pojo_Yaml_Json.MyPojo;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.io.FileWriter;

public class ReadJson {
    @Test
    public void readJson1() throws  Exception {

        String jsonPath = "src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/myJson.json";
        FileReader file=new FileReader(jsonPath); // okuduk

        ObjectMapper mapper = new ObjectMapper(); // pojo ile json u eslestirmek ,file yi mapper ile pojo ya aktardik

        MyPojo myPojo = mapper.readValue(file, MyPojo.class); // mypojo dan nesne olusturduk ve  bunu oku ve return et

        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

        // burdaki datalar mypojo class a atildi


    }
    @Test
    public void WriteJson1() throws  Exception {

        String jsonPath = "src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/myJson.json";
        ObjectMapper mapper = new ObjectMapper();
        MyPojo myPojo = mapper.readValue(new FileReader(jsonPath), MyPojo.class);
        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

        myPojo.setPassword("admin123456"); // passwordu degistik
        FileWriter writer=new FileWriter(jsonPath); //yazmak icin nesne olusturduk ve json ustune yaz dedik
        mapper.writeValue(writer,myPojo);  // boylece yazdirdik ve run edince json file deki deger degisecek

    }
}