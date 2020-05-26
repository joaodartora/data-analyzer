package com.joaodartora.dataanalyzer.file;

import com.joaodartora.dataanalyzer.config.FileConfig;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class Reader extends FileConfig {

    private final static Logger logger = Logger.getLogger(String.valueOf(Reader.class));

    public List<String> read(String fileName) {
        logger.info("Reading the file: " + fileName);
        File flatFile = new File(FILE_PATH_INPUT + fileName);
        try {
            return Files.readAllLines(flatFile.toPath());
        } catch (IOException e) {
            logger.warning("An IO error occurred while reading the file: " + fileName);
            return new ArrayList<>();
        }
    }
}
