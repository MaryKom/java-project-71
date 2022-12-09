package hexlet.code;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import static hexlet.code.Parser.parse;
import static hexlet.code.Tree.buildTree;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> firstFileToMap = getData(filepath1);
        Map<String, Object> secondFileToMap = getData(filepath2);

        List<Node> differMap = buildTree(firstFileToMap, secondFileToMap);
        return Formatter.format(differMap, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static Map<String, Object> getData(String filepath) throws Exception {
        Path path = Paths.get(filepath);
        String stringFromFile = new String(Files.readAllBytes(path));
        String format = getFormatFile(filepath);
        return parse(stringFromFile, format);
    }

    public static String getFormatFile(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }
}
