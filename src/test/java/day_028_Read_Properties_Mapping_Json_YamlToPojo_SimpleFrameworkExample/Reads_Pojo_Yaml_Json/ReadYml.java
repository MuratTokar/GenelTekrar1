package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.Reads_Pojo_Yaml_Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.Reads_Pojo_Yaml_Json.MyPojo;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;

public class ReadYml {
    @Test
    public void readYaml() throws  Exception {

        String yamlPath = "src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/ReadYml.java";
        FileReader file=new FileReader(yamlPath); // okuduk

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory()); // pojo ile json u eslestirmek ,file yi mapper ile pojo ya aktardik

        MyPojo myPojo = mapper.readValue(file, MyPojo.class); // mypojo dan nesne olusturduk ve  bunu oku ve return et
           // json dan tek farki objecktmapper icine new YAMLFactory yazmak ve pom a yaml eklemek
        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

        // burdaki datalar mypojo class a atildi


    }
    @Test
    public void WriteYaml1() throws  Exception {

        String yamlPath = "src/test/java/day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample/myYaml.yml";
        FileReader file=new FileReader(yamlPath);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        MyPojo myPojo = mapper.readValue(file,MyPojo.class);
        System.out.println("myPojo.getUrl() = " + myPojo.getUrl());
        System.out.println("myPojo.getUsername() = " + myPojo.getUsername());
        System.out.println("myPojo.getPassword() = " + myPojo.getPassword());

        myPojo.setPassword("admin123"); // passwordu degistik
        FileWriter writer=new FileWriter(yamlPath); //yazmak icin nesne olusturduk ve json ustune yaz dedik
        mapper.writeValue(writer,myPojo);  // boylece yazdirdik ve run edince json file deki deger degisecek

    }
}