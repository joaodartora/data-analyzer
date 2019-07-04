package com.joaodartora.core.challenge.app;

import java.io.File;
import java.util.List;

import com.joaodartora.core.challenge.analysis.DataAnalysis;
import com.joaodartora.core.challenge.dao.DataReader;
import com.joaodartora.core.challenge.dao.DataWriter;
import com.joaodartora.core.challenge.dao.FileFinder;

public class App {
	
	private static final String INPUT_DIRECTORY = "data/in";
	private static final String OUTPUT_DIRECTORY = "data/out/";

	public static void main(String[] args) {
		
		FileFinder fileFinder = new FileFinder(); 
		DataReader dataReader = new DataReader();
		DataAnalysis dataAnalysis = new DataAnalysis();
		DataWriter dataWriter = new DataWriter();
		
		List<List> fileData;
		List<File> listOfFiles = fileFinder.createListOfReadableFiles(INPUT_DIRECTORY);
		
		for(File fl:listOfFiles) {
			
			fileData = dataReader.readFile(fl);
			dataWriter.writeOutputFile(OUTPUT_DIRECTORY
					,dataReader.readFileName(fl)
					,dataAnalysis.generateAmountOfSalesman(fileData)
					,dataAnalysis.generateAmountOfCustomer(fileData)
					,dataAnalysis.findMostExpensiveSaleId(fileData)
					,dataAnalysis.findWorstSalesmanEver(fileData));
		}
	}
}
