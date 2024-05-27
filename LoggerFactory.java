package log2;

public class LoggerFactory {
    public static Logger onConsole() {
        return new LoggerConsole();
    }

    public static Logger onFile(String fileName) {
        return new LoggerFile(fileName);
    }
}

