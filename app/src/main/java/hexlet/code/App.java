package hexlet.code;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable {
    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;
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
            return SUCCESS_EXIT_CODE;
        } catch (Exception e) {
            return ERROR_EXIT_CODE;
        }
    }
    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
