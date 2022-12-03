import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDiffer {
    private final String filepath1Json = ("src/test/resources/file1.json");
    private final String filepath2Json = ("src/test/resources/file2.json");

    @Test
    public void generateDefaultTestJson() throws Exception {
        String actual = Differ.generate(filepath1Json, filepath2Json);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_json"));
        assertThat(actual).isEqualTo(expected);
    }
}
