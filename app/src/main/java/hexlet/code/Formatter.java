package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String format(Map<String, String> differMap, Map<String, Object> map1,
                                Map<String, Object> map2, String format) throws Exception {
        switch (format) {
            case "plain":
                return Plain.format(differMap, map1, map2);
            case "json":
                return Json.format(differMap, map1, map2);
            default:
                return Stylish.format(differMap, map1, map2);
        }
    }
}
