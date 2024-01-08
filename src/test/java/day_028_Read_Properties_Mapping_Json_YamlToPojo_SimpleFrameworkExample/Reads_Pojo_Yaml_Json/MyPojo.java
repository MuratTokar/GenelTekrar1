package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample.Reads_Pojo_Yaml_Json;

import lombok.Data;

@Data
public class MyPojo {
    // getter ve setter kullanir.basina @Data yazinca lombok dan otomatik alir set ve get leri
    private String url;
    private String username;
    private String password;
}
