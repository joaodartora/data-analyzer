package com.joaodartora.dataanalyzer.file;

import com.joaodartora.dataanalyzer.config.FileConfig;
import com.joaodartora.dataanalyzer.model.AnalyzedData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Writer extends FileConfig {

    private final static Logger logger = Logger.getLogger(String.valueOf(Writer.class));

    public void writeOutputFile(AnalyzedData dataToWrite, String filename) {
        logger.log(Level.INFO, "Writing the file {}", filename);
        String filenameWithoutExtension = filename.replace(FILE_EXTENSION, "");
        Path path = Path.of(FILE_PATH_OUTPUT.concat(filenameWithoutExtension).concat(DONE_FILE_EXTENSION));
        try {
            Files.write(path, dataToWrite.getAnalyzedDataAsBytes());
        } catch (IOException e) {
            logger.log(Level.WARNING, "Error writing output file", e);
        }
    }
}
