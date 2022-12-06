package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

import static hexlet.code.Parser.parse;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);

        List<Node> differMap = differMap(firstFileToMap, secondFileToMap);
        return Formatter.format(differMap, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        String stringFromFile = new String(Files.readAllBytes(Paths.get(filepath)));
        return parse(stringFromFile, getFormatFile(filepath));
    }

    public static String getFormatFile(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }

    public static List<Node> differMap(Map<String, Object> map1, Map<String, Object> map2) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());
        List<Node> allDifferences = new ArrayList<>();
        for (String key: keys) {
            if (!map1.containsKey(key)) {
                allDifferences.add(new Node("added", key, map2.get(key), map1.get(key)));
            } else if (!map2.containsKey(key)) {
                allDifferences.add(new Node("deleted", key, map2.get(key), map1.get(key)));
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                allDifferences.add(new Node("changed", key, map2.get(key), map1.get(key)));
            } else {
                allDifferences.add(new Node("unchanged", key, map2.get(key), map1.get(key)));
            }
        }
        return allDifferences;
    }
}
