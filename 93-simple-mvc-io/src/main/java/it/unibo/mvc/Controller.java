package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Objects;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    public static final String HOME_DIR = System.getProperty("user.home");
    private static final String SEP = System.getProperty("file.separator");

    private File currentFile;

    public Controller() {
        this.currentFile = new File(HOME_DIR + SEP + "output.txt");
    }

    public void setFile(final File currentFile) {
        this.currentFile = Objects.requireNonNull(currentFile, "Should not pass a null file");
    }

    public File getFile() {
        return this.currentFile;
    }

    public String getFilePath() {
        return this.currentFile.getAbsolutePath();
    }

    public void writeString(final String content) throws IOException {
        try (final var ps = new PrintStream(this.currentFile)){
            ps.println(content);
        }
    }
}
