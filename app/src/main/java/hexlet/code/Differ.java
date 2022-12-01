package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static hexlet.code.Parser.parse;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);

        Map<String, String> differMap = differMap(firstFileToMap, secondFileToMap);
        //System.out.println(differMap);
        return Stylish.format(differMap, firstFileToMap, secondFileToMap);
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        String stringFromFile = new String(Files.readAllBytes(Paths.get(filepath)));
        return parse(stringFromFile);
    }

    public static Map<String, String> differMap(Map<String, Object> map1, Map<String, Object> map2) {
        Set <String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        Map <String, String> result = new TreeMap<>();
        for (String key: keys) {
            if (!map1.containsKey(key)) {
                result.put(key, "added");
            } else if (!map2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (!Objects.equals(map1.get(key), map2.get(key))) {
                result.put(key, "changed");
            } else {
                result.put(key, "unchanged");
            }
        }
        return result;
    }
}
