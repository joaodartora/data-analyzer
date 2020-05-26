package com.joaodartora.dataanalyzer.test.service;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Customer;
import com.joaodartora.dataanalyzer.model.Sales;
import com.joaodartora.dataanalyzer.model.Salesman;
import com.joaodartora.dataanalyzer.service.ParseService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParseServiceTest {

    private final ParseService parseService;

    public ParseServiceTest() {
        parseService = new ParseService();
    }

    @Test
    public void parseFileLinesWithSuccessShouldReturnABaseModelsListWithCorrectParsedModels() {
        List<BaseModel> modelList = parseService.parseLinesAccordingToType(buildCorrectFileLines());

        assertEquals(9, modelList.size());
        assertAll("Check all list classes",
                () -> assertAll("Check all Salesman",
                        () -> assertEquals(Salesman.class, modelList.get(0).getClass()),
                        () -> assertEquals(Salesman.class, modelList.get(2).getClass()),
                        () -> assertEquals(Salesman.class, modelList.get(7).getClass())
                ),
                () -> assertAll("Check all Customers",
                        () -> assertEquals(Customer.class, modelList.get(1).getClass()),
                        () -> assertEquals(Customer.class, modelList.get(3).getClass()),
                        () -> assertEquals(Customer.class, modelList.get(5).getClass())
                ),
                () -> assertAll("Check all Sales",
                        () -> assertEquals(Sales.class, modelList.get(4).getClass()),
                        () -> assertEquals(Sales.class, modelList.get(6).getClass()),
                        () -> assertEquals(Sales.class, modelList.get(8).getClass())
                )
        );
    }

    @Test
    public void parseFileLinesWithEmptyLinesShouldReturnAEmptyList() {
        List<BaseModel> modelList = parseService.parseLinesAccordingToType(buildEmptyAndNullFileLines());

        assertEquals(0, modelList.size());
    }

    @Test
    public void parseFileLinesWithOneUnparseableFileLineShouldReturnCorrectListSizeWithoutUnparseableFile() {
        List<BaseModel> modelList = parseService.parseLinesAccordingToType(buildFileLinesWithUnparseableFileLine());

        assertEquals(3, modelList.size());
    }

    private List<String> buildCorrectFileLines() {
        return Arrays.asList("001ç1234567891234çNuanel Lessiç50000",
                "002ç2345675434544345çGiovano ZattoçAgronomo",
                "001ç3245678865434çRenato Schustoç40000.99",
                "002ç2345675434544345çJose da SilvaçRural",
                "003ç11ç[1-10-100,2-30-2.50,3-40-3.10]çThales",
                "002ç2345675434544345çSilipe FilveiraçTecnologia",
                "003ç08ç[1-34-1,2-33-0.50,3-5-0.10]çCico",
                "001ç3245678865434çBandre Aladaç40000.99",
                "003ç14ç[1-34-70,2-33-1.50,3-40-5.10]çGeorgenis)");
    }

    private List<String> buildEmptyAndNullFileLines() {
        return Arrays.asList("", null, "", null, "", "");
    }

    private List<String> buildFileLinesWithUnparseableFileLine() {
        return Arrays.asList("001ç1234567891234çNuanel Lessiç50000",
                "002ç2345675434544345çGiovano ZattoçAgronomo",
                "004çQuanticCoachçBoloLoiroçPegasus",
                "003ç11ç[1-10-100,2-30-2.50,3-40-3.10]çThales");
    }
}
