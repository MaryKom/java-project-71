package hexlet.code;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Objects;

public class Tree {
    public static List<Node> buildTree(Map<String, Object> map1, Map<String, Object> map2) {
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
