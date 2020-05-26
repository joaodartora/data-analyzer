package com.joaodartora.dataanalyzer.config;

import java.io.File;

public class FileConfig {

    public static final String FILE_PATH_INPUT = System.getProperty("user.home") + File.separator + "data" + File.separator + "in" + File.separator;
    public static final String FILE_PATH_OUTPUT = System.getProperty("user.home") + File.separator + "data" + File.separator + "out" + File.separator;
    public static final String FILE_EXTENSION = ".dat";
    public static final String DONE_FILE_EXTENSION = ".done.dat";

}
