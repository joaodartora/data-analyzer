package com.joaodartora.dataanalyzer.service;

import com.joaodartora.dataanalyzer.exception.InexistentMostExpensiveSaleIdException;
import com.joaodartora.dataanalyzer.exception.InexistentWorstSalesmanException;
import com.joaodartora.dataanalyzer.model.AnalyzedData;
import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Customer;
import com.joaodartora.dataanalyzer.model.Item;
import com.joaodartora.dataanalyzer.model.Sales;
import com.joaodartora.dataanalyzer.model.Salesman;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalysisService {

    public AnalyzedData getAnalyzedData(List<BaseModel> parsedData) {

        var customersList = getDataListFromModelClass(parsedData, Customer.class);
        var salesmenList = getDataListFromModelClass(parsedData, Salesman.class);
        var salesList = getDataListFromModelClass(parsedData, Sales.class);
        return AnalyzedData.of()
                .amountOfCustomer(customersList.size())
                .amountOfSalesman(salesmenList.size())
                .mostExpensiveSaleId(findMostExpensiveSaleId(salesList))
                .worstSalesmanEver(findWorstSalesmanEver(salesList))
                .build();
    }

    private Integer findMostExpensiveSaleId(List<Sales> salesList) {
        return salesList.stream()
                .max(Comparator.comparing(this::calculateSalesTotalValue))
                .orElseThrow(InexistentMostExpensiveSaleIdException::new)
                .getSaleId();
    }

    private BigDecimal calculateSalesTotalValue(Sales sale) {
        return sale.getItem().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private String findWorstSalesmanEver(List<Sales> salesList) {
        return salesList.stream()
                .collect(Collectors.toMap(Sales::getSalesmanName, sales -> getSalePrice(sales.getItem()), BigDecimal::add))
                .entrySet()
                .stream()
                .min(Map.Entry.comparingByValue())
                .orElseThrow(InexistentWorstSalesmanException::new)
                .getKey();
    }

    private BigDecimal getSalePrice(List<Item> saleItems) {
        return saleItems.stream()
                .map(item -> item.getPrice().multiply(new BigDecimal(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private <E> List<E> getDataListFromModelClass(List<BaseModel> parsedModels, Class<E> modelClass) {
        return parsedModels.stream()
                .filter(baseModel -> modelClass.getSimpleName().equals(baseModel.getClass().getSimpleName()))
                .map(modelClass::cast)
                .collect(Collectors.toList());
    }
}
