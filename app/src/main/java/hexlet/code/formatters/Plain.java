package hexlet.code.formatters;

import java.util.Map;

public class Plain {
    public static String format(Map<String, String> differMap, Map<String, Object> map1, Map<String, Object> map2) {
        String result = "";
        for (Map.Entry<String, String> element : differMap.entrySet()) {
            String key = element.getKey();
            switch (element.getValue()) {
                case "added":
                    result += "Property '" + key + "' was added with value: " + getValue(map2.get(key)) + "\n";
                    break;
                case "deleted":
                    result += "Property '" + key + "' was removed\n";
                    break;
                case "changed":
                    result += "Property '" + key + "' was updated. From " + getValue(map1.get(key))
                            + " to " + getValue(map2.get(key)) + "\n";
                    break;
                default:
                    break;
            }
        }
        return result;
    }

    private static String getValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        } else if (!(value instanceof Integer) && !(value instanceof Boolean)) {
            return "[complex value]";
        }
        return value.toString();
    }
}
