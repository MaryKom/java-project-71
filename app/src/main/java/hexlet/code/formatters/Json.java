package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Node;
import java.util.List;

public class Json {
    public static String format(List<Node> differTree) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(differTree);
    }
}
