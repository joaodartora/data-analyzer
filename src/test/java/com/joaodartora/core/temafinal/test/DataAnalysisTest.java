package com.joaodartora.core.temafinal.test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.joaodartora.core.temafinal.analysis.DataAnalysis;
import com.joaodartora.core.temafinal.model.Customer;
import com.joaodartora.core.temafinal.model.Item;
import com.joaodartora.core.temafinal.model.Sales;
import com.joaodartora.core.temafinal.model.Salesman;

public class DataAnalysisTest {

	private DataAnalysis dataAnalysis;
	private List<List> testList;
	
	@Before
	public void beforeEach() {
		dataAnalysis = new DataAnalysis();
		testList = new ArrayList<List>();
	}
	
	@Test
	public void testGenerateAmountOfSalesman() {
		List<Salesman> salesManList = new ArrayList<Salesman>();
		salesManList.add(new Salesman());
		salesManList.add(new Salesman());
		testList.add(salesManList);
		assertEquals("Error generating the amount of salesman", 2, dataAnalysis.generateAmountOfSalesman(testList));
	}

	@Test
	public void testGenerateAmountOfCustomer() {
		List<Customer> customerList = new ArrayList<Customer>();
		List<Customer> customerList2 = new ArrayList<Customer>();
		customerList.add(new Customer());
		customerList.add(new Customer());
		testList.add(customerList);
		testList.add(customerList2);
		assertEquals("Error generating the amount of customer", 2, dataAnalysis.generateAmountOfSalesman(testList));
	}

	@Test
	public void testFindMostExpensiveSaleId() {
		List<Sales> salesList = new ArrayList<Sales>();
		List<Sales> salesList2 = new ArrayList<Sales>();
		List<Sales> salesList3 = new ArrayList<Sales>();
		List<Item> itemList = new ArrayList<Item>();
		itemList.add(new Item(22, 55, 77));
		salesList.add(new Sales(99, itemList, "Joao"));
		testList.add(salesList3);
		testList.add(salesList2);
		testList.add(salesList);
		assertEquals("Error generating the most expensive sale", 99, dataAnalysis.findMostExpensiveSaleId(testList));
	}
}
