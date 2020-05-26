package com.joaodartora.dataanalyzer.test.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Sales;
import com.joaodartora.dataanalyzer.parser.SalesParser;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalesParserTest {

    private final SalesParser salesParser;

    public SalesParserTest() {
        salesParser = new SalesParser();
    }

    @Test
    public void parseAnElegibleLineWithSuccessShouldReturnOptionalWithCustomer() {
        String lineWithCorrectSales = "003ç08ç[1-34-1,2-33-0.50,3-5-0.10]çGesonel";

        Optional<BaseModel> sales = salesParser.parse(lineWithCorrectSales);

        assertTrue(sales.isPresent());
        assertAll("Check sales values",
                () -> assertEquals(8, ((Sales) sales.get()).getSaleId()),
                () -> assertEquals("Gesonel", ((Sales) sales.get()).getSalesmanName()),
                () -> assertAll("Check sales itens values",
                        () -> assertEquals(1, ((Sales) sales.get()).getItem().get(0).getId()),
                        () -> assertEquals(34, ((Sales) sales.get()).getItem().get(0).getQuantity()),
                        () -> assertEquals(BigDecimal.valueOf(1), ((Sales) sales.get()).getItem().get(0).getPrice()),
                        () -> assertEquals(2, ((Sales) sales.get()).getItem().get(1).getId()),
                        () -> assertEquals(33, ((Sales) sales.get()).getItem().get(1).getQuantity()),
                        () -> assertEquals(BigDecimal.valueOf(0.50D).setScale(2, RoundingMode.HALF_EVEN), ((Sales) sales.get()).getItem().get(1).getPrice()),
                        () -> assertEquals(3, ((Sales) sales.get()).getItem().get(2).getId()),
                        () -> assertEquals(5, ((Sales) sales.get()).getItem().get(2).getQuantity()),
                        () -> assertEquals(BigDecimal.valueOf(0.10D).setScale(2, RoundingMode.HALF_EVEN), ((Sales) sales.get()).getItem().get(2).getPrice()))
        );
    }

    @Test
    public void parseAnNotElegibleLineWithIncorrectSalesDelimitersShouldThrowIllegalStateExceptionWithMessage() {
        String lineWithIncorrectSales = "003+08+[1-34-1,2-33-0.50,3-5-0.10]+Esteban";

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> salesParser.parse(lineWithIncorrectSales));

        assertEquals("No match found", exception.getMessage());
    }

    @Test
    public void parseAnNotElegibleLineWithIncorrectSalesItensDelimitersShouldThrowIllegalStateExceptionWithMessage() {
        String lineWithIncorrectSales = "003ç08ç[1*34*1,2*33*0.50,3*5*0.10]çGelson";

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> salesParser.parse(lineWithIncorrectSales));

        assertEquals("No match found", exception.getMessage());
    }

    @Test
    public void verifyIfLineIsEligibleWithSuccessShouldReturnTrue() {
        String lineWithCorrectSales = "003ç08ç[1-34-1,2-33-0.50,3-5-0.10]çVovo Juju";

        Boolean isEligible = salesParser.isElegible(lineWithCorrectSales);

        assertTrue(isEligible);
    }

    @Test
    public void verifyIfLineIsEligibleWithErrorShouldReturnFalse() {
        String lineWithIncorrectSales = "003ç085645ç[1-34-1;2-33-0.50;3-5-0.10]çJaspion";

        Boolean isEligible = salesParser.isElegible(lineWithIncorrectSales);

        assertFalse(isEligible);
    }

}
