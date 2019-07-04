package com.joaodartora.core.temafinal.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {

	public boolean writeOutputFile (String directory, String fileName, int amountOfSalesman, int amountOfCustomer, long mostExpensiveSaleId, String worstSalesmanEver) {
		
		String outputPath = "";
		String[] fileExtension = fileName.split("\\.");
		fileName = fileName.substring(0, fileName.length()-fileExtension[1].length());
		outputPath = outputPath.concat(directory).concat(fileName).concat("done.").concat(fileExtension[1]);
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath));){
			writer.write("Amount of customers in the file: "+amountOfCustomer+" - ");
			writer.write("Amount of salesman in the file: "+amountOfSalesman+" - ");
			writer.write("ID of the most expensive sale: "+mostExpensiveSaleId+" - ");
			writer.write("Worst salesman ever: "+worstSalesmanEver);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
