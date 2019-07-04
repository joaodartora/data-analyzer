package com.joaodartora.core.temafinal.test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.joaodartora.core.temafinal.dao.FileFinder;

public class FileFinderTest {

	private static final String DIRECTORY = "data/in";
	
	@Test
	public void testCreateListOfReadableFiles() {
		
		FileFinder teste = new FileFinder();
		List<File> listaTeste =  teste.createListOfReadableFiles(DIRECTORY);
		assertNotNull("Error creating the list!", listaTeste);
	}
}
