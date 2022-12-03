import hexlet.code.Differ;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Paths;

public class TestDiffer {
    private final String filepath1Json = ("src/test/resources/file1.json");
    private final String filepath2Json = ("src/test/resources/file2.json");
    private final String filepath1Yml = ("src/test/resources/file1.yml");
    private final String filepath2Yml = ("src/test/resources/file2.yml");

    @Test
    public void generateDefaultTestJson() throws Exception {
        String actual = Differ.generate(filepath1Json, filepath2Json);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_json.json"));
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generateTestDefaultYAML() throws Exception {
        String actual = Differ.generate(filepath1Yml, filepath2Yml);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_yml"));
        assertThat(actual).isEqualTo(expected);
    }
}
