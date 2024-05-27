package log2;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerFile implements Logger {
    private String fileName;

    LoggerFile(String fileName) {
        this.fileName = fileName;
    }

    private String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private void writeToFile(Level level, String message) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(getCurrentTime() + " [" + level + "] " + message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(Level level, String message) {
        writeToFile(level, message);
    }
}

