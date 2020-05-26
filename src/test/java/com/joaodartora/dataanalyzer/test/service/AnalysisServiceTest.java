package com.joaodartora.dataanalyzer.test.service;

import com.joaodartora.dataanalyzer.exception.InexistentMostExpensiveSaleIdException;
import com.joaodartora.dataanalyzer.model.AnalyzedData;
import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.service.AnalysisService;
import com.joaodartora.dataanalyzer.test.stub.BaseModelStub;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnalysisServiceTest {

    private final AnalysisService analysisService;

    public AnalysisServiceTest() {
        analysisService = new AnalysisService();
    }

    @Test
    public void getAnalyzedDataWithSuccessShouldReturnCorrectValues() {
        List<BaseModel> baseModelList = BaseModelStub.createListWithAllElements();

        AnalyzedData analyzedData = analysisService.getAnalyzedData(baseModelList);

        assertAll("Check analyzed data values",
                () -> assertEquals(1, analyzedData.getAmountOfCustomer()),
                () -> assertEquals(1, analyzedData.getAmountOfSalesman()),
                () -> assertEquals(3108, analyzedData.getMostExpensiveSaleId()),
                () -> assertEquals("Astolfinho Maciel", analyzedData.getWorstSalesmanEver())
        );
    }

    @Test
    public void getAnalyzedDataWithoutSalesmanShouldReturnCorrectValuesWithZeroSalesman() {
        List<BaseModel> baseModelList = BaseModelStub.createListWithoutSalesman();

        AnalyzedData analyzedData = analysisService.getAnalyzedData(baseModelList);

        assertAll("Check analyzed data values",
                () -> assertEquals(2, analyzedData.getAmountOfCustomer()),
                () -> assertEquals(0, analyzedData.getAmountOfSalesman()),
                () -> assertEquals(3108, analyzedData.getMostExpensiveSaleId()),
                () -> assertEquals("Astolfinho Maciel", analyzedData.getWorstSalesmanEver())
        );
    }

    @Test
    public void getAnalyzedDataWithoutCustomersShouldReturnCorrectValuesWithZeroCustomer() {
        List<BaseModel> baseModelList = BaseModelStub.createListWithoutCustomer();

        AnalyzedData analyzedData = analysisService.getAnalyzedData(baseModelList);

        assertAll("Check analyzed data values",
                () -> assertEquals(0, analyzedData.getAmountOfCustomer()),
                () -> assertEquals(2, analyzedData.getAmountOfSalesman()),
                () -> assertEquals(3108, analyzedData.getMostExpensiveSaleId()),
                () -> assertEquals("Astolfinho Maciel", analyzedData.getWorstSalesmanEver())
        );
    }

    @Test
    public void getAnalyzedDataWithOnlySalesShouldReturnCorrectValues() {
        List<BaseModel> baseModelList = BaseModelStub.createListWithOnlySales();

        AnalyzedData analyzedData = analysisService.getAnalyzedData(baseModelList);

        assertAll("Check analyzed data values",
                () -> assertEquals(0, analyzedData.getAmountOfCustomer()),
                () -> assertEquals(0, analyzedData.getAmountOfSalesman()),
                () -> assertEquals(3108, analyzedData.getMostExpensiveSaleId()),
                () -> assertEquals("Astolfinho Maciel", analyzedData.getWorstSalesmanEver())
        );
    }

    @Test
    public void getAnalyzedDataWithNoMostExpensiveSaleShouldThrowInexistentMostExpensiveSaleIdException() {
        List<BaseModel> baseModelList = BaseModelStub.createListWithoutMostExpensiveSaleId();

        InexistentMostExpensiveSaleIdException exception = assertThrows(InexistentMostExpensiveSaleIdException.class, () -> analysisService.getAnalyzedData(baseModelList));

        assertEquals("There is no most expensive sale id", exception.getMessage());
    }
}