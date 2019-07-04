package com.joaodartora.core.challenge.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.joaodartora.core.challenge.exception.InexistentTypeOfDataException;
import com.joaodartora.core.challenge.model.Customer;
import com.joaodartora.core.challenge.model.Sales;
import com.joaodartora.core.challenge.model.Salesman;
import com.joaodartora.core.challenge.parsers.CustomerParser;
import com.joaodartora.core.challenge.parsers.SalesParser;
import com.joaodartora.core.challenge.parsers.SalesmanParser;

public class DataReader {

	private static final int BEGIN_IDENTIFIER_INDEX = 0;
	private static final int END_IDENTIFIER_INDEX = 3;
	private static final int DELIMITER_INDEX = 3;
	private static final int SALESMAN = 1;
	private static final int COSTUMER = 2;
	private static final int SALES = 3;
	
	SalesmanParser salesmanParser = new SalesmanParser();
	CustomerParser customerParser = new CustomerParser();
	SalesParser salesParser = new SalesParser();
	
	public String readFileName (File file) {
		return file.getName();
	}
	
	public List<List> readFile (File file) {
		
		String delimiter;
		String line;
		List<Salesman> salesmanList = new ArrayList<Salesman>();
		List<Customer> customerList = new ArrayList<Customer>();
		List<Sales> salesList = new ArrayList<Sales>();
		List<List> filesList = new ArrayList<List>();
		
		try (BufferedReader bufferReader = new BufferedReader(new FileReader(file));){
			
			while ((line = bufferReader.readLine()) != null) {
				delimiter = identifyDelimiter(line);
				switch (Integer.parseInt((line.substring(BEGIN_IDENTIFIER_INDEX, END_IDENTIFIER_INDEX)))) {
					
				case SALESMAN:
					Salesman salesman = salesmanParser.processSalesmanData(line, delimiter);
					salesmanList.add(salesman);
					break;
				case COSTUMER:
					Customer customer = customerParser.processCustomerData(line, delimiter);
					customerList.add(customer);
					break;
				case SALES:
					Sales sales = salesParser.processSalesData(line, delimiter);
					salesList.add(sales);
					break;
				default:
					throw new InexistentTypeOfDataException("This type of data is not accepted!");
				}
			}
		} catch (IOException io) {
			io.printStackTrace();
		} catch (InexistentTypeOfDataException itd) {
			itd.getMessage();
		} 
		filesList.add(salesmanList);
		filesList.add(customerList);
		filesList.add(salesList);
		return filesList;
	}
	
	protected String identifyDelimiter (String line) {
		return String.valueOf(line.charAt(DELIMITER_INDEX));
	}
}
