package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Stylish {
    public static String format(List<Node> differTree) {
        String result = "{\n";

        for (Node element : differTree) {
            String key = element.getKey();
            String typeOfChange = element.getTypeOfChange();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();
            switch (typeOfChange) {
                case "added":
                    result += "  + " + key + ": " + newValue + "\n";
                    break;
                case "deleted":
                    result += "  - " + key + ": " + oldValue + "\n";
                    break;
                case "changed":
                    result += "  - " + key + ": " + oldValue + "\n";
                    result += "  + " + key + ": " + newValue + "\n";
                    break;
                case "unchanged":
                    result += "    " + key + ": " + newValue + "\n";
                    break;
                default:
                    break;
            }
        }
        result += "}";
        return result;
    }
}
