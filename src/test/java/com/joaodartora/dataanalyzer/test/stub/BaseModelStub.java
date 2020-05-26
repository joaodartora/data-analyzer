package com.joaodartora.dataanalyzer.test.stub;

import com.joaodartora.dataanalyzer.model.BaseModel;

import java.util.Arrays;
import java.util.List;

import static com.joaodartora.dataanalyzer.test.stub.CustomerStub.createCustomer;
import static com.joaodartora.dataanalyzer.test.stub.SalesStub.createSales;
import static com.joaodartora.dataanalyzer.test.stub.SalesmanStub.createSalesman;

public class BaseModelStub {

    public static List<BaseModel> createListWithAllElements() {
        return Arrays.asList(createCustomer(), createSales(), createSalesman());
    }

    public static List<BaseModel> createListWithOnlySales() {
        return Arrays.asList(createSales(), createSales(), createSales());
    }

    public static List<BaseModel> createListWithoutSalesman() {
        return Arrays.asList(createCustomer(), createSales(), createCustomer());
    }

    public static List<BaseModel> createListWithoutCustomer() {
        return Arrays.asList(createSalesman(), createSales(), createSalesman());
    }

    public static List<BaseModel> createListWithoutMostExpensiveSaleId() {
        return Arrays.asList(createCustomer(), createSalesman(), createCustomer());
    }
}
