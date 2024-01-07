package day_028_Read_Properties_Mapping_Json_YamlToPojo_SimpleFrameworkExample;

import lombok.Data;

@Data
public class MyPojo {
    // getter ve setter kullanir.basina @Data yazinca lombok dan otomatik alir set ve get leri
    private String url;
    private String username;
    private String password;
}
