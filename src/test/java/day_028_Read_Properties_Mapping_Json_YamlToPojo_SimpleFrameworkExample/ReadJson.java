package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import java.io.FileReader;
public class ReadJson {
    @Test
    public void readJson1() throws  Exception {

        String jsonPath = "src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/myJson.json";
        ObjectMapper mapper = new ObjectMapper();
        MyPojo myPojo = mapper.readValue(new FileReader(jsonPath), MyPojo.class);
        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

        // burdaki datalar mypojo class a atildi


    }
}