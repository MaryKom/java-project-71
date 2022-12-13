package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {
    private final Integer errorCode = 404;
    @Parameters(index = "0", description = "path to first file")
    private static String filepath1;
    @Parameters(index = "1", description = "path to second file")
    private static String filepath2;

    @Option(names = {"-f", "--format"}, description = "output format \"stylish\" or \"plain\" "
            + "or \"json\" [default: stylish]")
    private String format = "stylish";

    @Override
    public final Integer call() throws Exception {
        try {
            System.out.println(Differ.generate(filepath1, filepath2, format));
            return 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return errorCode;
        }
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
