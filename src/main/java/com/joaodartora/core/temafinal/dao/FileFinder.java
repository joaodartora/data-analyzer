package com.joaodartora.core.temafinal.dao;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class FileFinder {
	
	public List<File> createListOfReadableFiles (String directory) {
		return Arrays.asList(new File(directory).listFiles());
	}
}
