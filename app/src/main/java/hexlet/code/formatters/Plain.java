package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Plain {
    public static String format(List<Node> differTree) {
        String result = "";
        for (Node element : differTree) {
            String key = element.getKey();
            String typeOfChange = element.getTypeOfChange();
            Object oldValue = element.getOldValue();
            Object newValue = element.getNewValue();
            switch (typeOfChange) {
                case "added":
                    result += "Property '" + key + "' was added with value: " + getValue(newValue) + "\n";
                    break;
                case "deleted":
                    result += "Property '" + key + "' was removed\n";
                    break;
                case "changed":
                    result += "Property '" + key + "' was updated. From " + getValue(oldValue)
                            + " to " + getValue(newValue) + "\n";
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
