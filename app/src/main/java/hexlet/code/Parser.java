package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Map;

public class Parser {
    public static Map<String, Object> parse(String content, String formatFile) throws Exception {
        ObjectMapper objectMapper;
        String format = formatFile.toLowerCase();
        switch (format) {
            case "yaml", "yml" -> {
                return parseYml(content);
            }
            case "json" -> {
                return parseJson(content);
            }
            default -> throw new Exception("Unknown format: '" + formatFile + "'");
        }
    }

    public static Map<String, Object> parseYml(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }

    public static Map<String, Object> parseJson(String content) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() { });
    }
}
