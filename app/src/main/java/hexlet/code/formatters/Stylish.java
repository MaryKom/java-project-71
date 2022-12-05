package hexlet.code.formatters;
import java.util.Map;

public class Stylish {
    public static String format(Map<String, String> differMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = "{\n";

        for (Map.Entry<String, String> element : differMap.entrySet()) {
            String key = element.getKey();
            switch (element.getValue()) {
                case "added":
                    result += "  + " + key + ": " + map2.get(key) + "\n";
                    break;
                case "deleted":
                    result += "  - " + key + ": " + map1.get(key) + "\n";
                    break;
                case "changed":
                    result += "  - " + key + ": " + map1.get(key) + "\n";
                    result += "  + " + key + ": " + map2.get(key) + "\n";
                    break;
                case "unchanged":
                    result += "    " + key + ": " + map2.get(key) + "\n";
                    break;
                default:
                    break;
            }
        }
        result += "}";
        return result;
    }
}
