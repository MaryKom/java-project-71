package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String formatFile) throws Exception {
        ObjectMapper objectMapper;
        if (formatFile.equalsIgnoreCase("json")) {
            objectMapper = new ObjectMapper();
        } else {
            objectMapper = new ObjectMapper(new YAMLFactory());
        }
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
