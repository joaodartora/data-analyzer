package com.joaodartora.dataanalyzer.file;

import com.joaodartora.dataanalyzer.config.FileConfig;
import com.joaodartora.dataanalyzer.exception.InvalidFileExtensionException;
import com.joaodartora.dataanalyzer.service.ProcessService;

import java.nio.file.WatchEvent;

public class Processor {

    private static final Watcher watcher = new Watcher();

    public static void verifyNewFilesAndStartProccessing() {
        watcher.getEvents()
                .stream()
                .map(WatchEvent::context)
                .map(Object::toString)
                .filter(Processor::validateFileExtension)
                .forEach(ProcessService::processFile);
    }

    private static Boolean validateFileExtension(String fileName) {
        boolean isValidFileExtension = fileName.endsWith(FileConfig.FILE_EXTENSION) && !fileName.endsWith(FileConfig.DONE_FILE_EXTENSION);
        if (!isValidFileExtension) throw new InvalidFileExtensionException(fileName);
        return true;
    }

}

