package com.joaodartora.dataanalyzer.test.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Salesman;
import com.joaodartora.dataanalyzer.parser.SalesmanParser;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SalesmanParserTest {

    private final SalesmanParser salesmanParser;

    public SalesmanParserTest() {
        salesmanParser = new SalesmanParser();
    }

    @Test
    public void parseAnElegibleLineWithSuccessShouldReturnOptionalWithCustomer() {
        String lineWithCorrectSalesman = "001ç1234567891234çClex Arvalhoç50000";

        Optional<BaseModel> salesman = salesmanParser.parse(lineWithCorrectSalesman);

        assertTrue(salesman.isPresent());
        assertAll("Check salesman values",
                () -> assertEquals("1234567891234", ((Salesman) salesman.get()).getCpf()),
                () -> assertEquals("Clex Arvalho", ((Salesman) salesman.get()).getName()),
                () -> assertEquals(BigDecimal.valueOf(50000), ((Salesman) salesman.get()).getSalary())
        );
    }

    @Test
    public void parseAnNotElegibleLineShouldThrowIllegalStateExceptionWithMessage() {
        String lineWithIncorrectSalesman = "001-1234567891234-Sduarda Eoares-50000";

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> salesmanParser.parse(lineWithIncorrectSalesman));

        assertEquals("No match found", exception.getMessage());
    }

    @Test
    public void verifyIfLineIsEligibleWithSuccessShouldReturnTrue() {
        String lineWithCorrectSalesman = "001ç1234567891234çBitalo Ironoroç50000";

        Boolean isEligible = salesmanParser.isElegible(lineWithCorrectSalesman);

        assertTrue(isEligible);
    }

    @Test
    public void verifyIfLineIsEligibleWithErrorShouldReturnFalse() {
        String lineWithIncorrectSalesman = "001-1234567891234-Sduarda Eoares-700,00";

        Boolean isEligible = salesmanParser.isElegible(lineWithIncorrectSalesman);

        assertFalse(isEligible);
    }

}
