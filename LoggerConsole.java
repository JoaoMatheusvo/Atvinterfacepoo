package log2;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerConsole implements Logger {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private String getColor(Level level) {
        switch (level) {
            case DEBUG: return GREEN;
            case WARNING: return YELLOW;
            case ERROR: return RED;
            default: return RESET;
        }
    }

    @Override
    public void log(Level level, String message) {
        System.out.println(getColor(level) + getCurrentTime() + " [" + level + "] " + message + RESET);
    }
}
