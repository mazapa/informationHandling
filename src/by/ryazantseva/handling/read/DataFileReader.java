package by.ryazantseva.handling.read;
import by.ryazantseva.handling.exception.DataFileReaderException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataFileReader {
    private static final int EMPTY = 0;
    private static Logger logger = LogManager.getLogger();

    public String readFromFile(String fileName) throws DataFileReaderException {
        String text;
        File file = new File(fileName);
        if (!file.exists() || file.length() == EMPTY) {
            logger.log(Level.FATAL, "Wrong file!");
            throw new RuntimeException();
        }
        try {
            text = new String(Files.readAllBytes(Paths.get(fileName)));
            logger.log(Level.INFO, "File has been read successfully");
        } catch (IOException e) {
            throw new DataFileReaderException("Problem with reading file", e);
        }
        return text;
    }
}

