package com.joaodartora.dataanalyzer.file;

import com.joaodartora.dataanalyzer.config.FileConfig;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Watcher extends FileConfig {

    private final static Logger logger = Logger.getLogger(String.valueOf(Watcher.class));

    private WatchService watcher;
    private WatchKey watchKey;
    private Path path;

    public Watcher() {
        watchFiles();
    }

    private void watchFiles() {
        try {
            path = Paths.get(FILE_PATH_INPUT);
            watcher = FileSystems.getDefault().newWatchService();
            path.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
            watchKey = watcher.take();
        } catch (IOException | InterruptedException e) {
            logger.log(Level.WARNING, "Error when monitoring new files in the folder", e);
        }
    }

    public List<WatchEvent<?>> getEvents() {
        return watchKey.pollEvents();
    }
}
