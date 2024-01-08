package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.controlbase.actions;

import day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.controlbase.utilss.Config;
import day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.controlbase.utilss.ConfigReader;
import utils.Driver;

public class ApplicationActions {
    public static void launchUrl(){
        Config config= ConfigReader.getInstance();
        Driver.getDriver(config.getBrowser()).get(config.getUrl());
    }

}
