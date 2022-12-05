package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedHashMap;
import java.util.Map;

public class Json {
    public static String format(Map<String, String> differMap, Map<String, Object> map1,
                                Map<String, Object> map2) throws Exception {
        Map<String, Object> map = new LinkedHashMap<>();
        for (Map.Entry<String, String> element : differMap.entrySet()) {
            String key = element.getKey();
            switch (element.getValue()) {
                case "added":
                    map.put("+ " + key, map2.get(key));
                    break;
                case "deleted":
                    map.put("- " + key, map1.get(key));
                    break;
                case "changed":
                    map.put("- " + key, map1.get(key));
                    map.put("+ " + key, map2.get(key));
                    break;
                case "unchanged":
                    map.put("  " + key, map2.get(key));
                    break;
                default:
                    break;
            }
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(map);
    }
}
