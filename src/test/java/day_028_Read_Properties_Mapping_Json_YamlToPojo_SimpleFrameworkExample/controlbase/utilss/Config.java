package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.controlbase.utilss;

import lombok.Data;

@Data // artik getter setter herseyi var
public class Config {
    private String url;
    private String username;
    private String password;
    private String browser;
}
