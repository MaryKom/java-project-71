import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    public void generateTestJson2() throws Exception {
        String filepath3Json = ("src/test/resources/file3.json");
        String filepath4Json = ("src/test/resources/file4.json");
        String expected = Files.readString(Paths.get("src/test/resources/stylish_json_2"));
        String actual = Differ.generate(filepath3Json, filepath4Json);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void generateTestYAML2() throws Exception {
        String filepath3Yml = ("src/test/resources/file3.yml");
        String filepath4Yml = ("src/test/resources/file4.yml");
        String actual = Differ.generate(filepath3Yml, filepath4Yml);
        String expected = Files.readString(Paths.get("src/test/resources/stylish_yml_2"));
        assertThat(actual).isEqualTo(expected);
    }
}
