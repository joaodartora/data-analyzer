package com.joaodartora.core.temafinal.test;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import com.joaodartora.core.temafinal.dao.DataReader;
import com.joaodartora.core.temafinal.parsers.CustomerParser;
import com.joaodartora.core.temafinal.parsers.SalesParser;
import com.joaodartora.core.temafinal.parsers.SalesmanParser;

public class DataReaderTest {

	private static final String DELIMITER = "/";
	private static final String DELIMITER2 = "ç";
	private static final String DELIMITER3 = "%";
	
	@Test public void testReadFileName() {
		String fileName = new DataReader().readFileName(new File("data/in/test4.txt"));
		assertEquals("The file name has not been correctly readed", "test4.txt", fileName);
	}
	
	@Test
	public void testReadFile() {
		File fileTest = new File("data/in/teste4.txt");
		assertNotNull("The file has not been correctly readed", new DataReader().readFile(fileTest));
	}

	@Test
	public void testProcessSalesmanData() {
		String lineTest = "001/1234567891234/Diego/50000";
		assertNotNull("The data of Salesman has not been correctly processed", new SalesmanParser().processSalesmanData(lineTest, DELIMITER));
	}

	@Test
	public void testProcessCustomerData() {
		String lineTest = "002ç2345675433444345çJose da SilvaçRural";
		assertNotNull("The data of Customer has not been correctly processed", new CustomerParser().processCustomerData(lineTest, DELIMITER2));
	}

	@Test
	public void testProcessSalesData() {
		String lineTest = "003%08%[1-34-10,2-33-1.50,3-40-0.10]%Renato";
		assertNotNull("The data of Sales has not been correctly processed", new SalesParser().processSalesData(lineTest, DELIMITER3));
	}
}
