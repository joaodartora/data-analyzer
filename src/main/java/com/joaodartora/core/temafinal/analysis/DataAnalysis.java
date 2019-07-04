package com.joaodartora.core.temafinal.analysis;

import java.util.Comparator;
import java.util.List;

import com.joaodartora.core.temafinal.model.Item;
import com.joaodartora.core.temafinal.model.Sales;
import com.joaodartora.core.temafinal.model.Salesman;

public class DataAnalysis {
	
	public int generateAmountOfSalesman (List<List> filesList) {
		return filesList.get(0).size();
	}
	
	public int generateAmountOfCustomer (List<List> filesList) {
		return filesList.get(1).size();
	}
	
	public long findMostExpensiveSaleId (List<List> filesList) {
		List<Sales> salesList = filesList.get(2);
		Sales mostExpensiveSale = new Sales();
		double mostExpensiveValue = 0;
		for (Sales sale: salesList) {
			if (calculateSalesTotalValue(sale) > mostExpensiveValue) mostExpensiveSale = sale;
		}
		return mostExpensiveSale.getSaleId();
	}

	public String findWorstSalesmanEver (List<List> filesList) {
		List<Salesman> salesmanTotalValues = calculateSalesmanTotalValues(filesList.get(2), filesList.get(0));
		return salesmanTotalValues.stream().min(Comparator.comparing(Salesman::getTotalValueSales)).get().getName();
	}
	
	protected List<Salesman> calculateSalesmanTotalValues (List<Sales> salesList, List<Salesman> salesmanList) {
		double totalValue = 0;
		double newTotalValue = 0;
		boolean findSalesman = false;
		List<Salesman> salesmanTotalValues = salesmanList;
		
		for (Sales s: salesList) {
			totalValue = calculateSalesTotalValue(s);
			for	(Salesman sm:salesmanTotalValues) {
				if (s.getSalesmanName().equals(sm.getName())) {
					newTotalValue = sm.getTotalValueSales();
					newTotalValue += totalValue;
					sm.setTotalValueSales(newTotalValue);
					findSalesman = true;
				} 
			}
			if (findSalesman == false) salesmanTotalValues.add(new Salesman(s.getSalesmanName(), totalValue));
		}
		return salesmanTotalValues;
	}
	
	protected double calculateSalesTotalValue (Sales sale) {
		double totalValue = 0;
		for (Item i: sale.getItem()) {
			totalValue += (i.getPrice()*i.getQuantity());
		}
		return totalValue;
	}
}
