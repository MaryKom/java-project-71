package hexlet.code;

import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public static String format(List<Node> differTree, String format) throws Exception {
        switch (format) {
            case "plain":
                return Plain.format(differTree);
            case "json":
                return Json.format(differTree);
            default:
                return Stylish.format(differTree);
        }
    }
}
