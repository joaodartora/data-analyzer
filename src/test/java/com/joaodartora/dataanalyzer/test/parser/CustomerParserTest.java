package com.joaodartora.dataanalyzer.test.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Customer;
import com.joaodartora.dataanalyzer.parser.CustomerParser;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomerParserTest {

    private final CustomerParser customerParser;

    public CustomerParserTest() {
        customerParser = new CustomerParser();
    }

    @Test
    public void parseAnElegibleLineWithSuccessShouldReturnOptionalWithCustomer() {
        String lineWithCorrectCustomer = "002ç2345675434544345çSeivid dos DantosçTech";

        Optional<BaseModel> customer = customerParser.parse(lineWithCorrectCustomer);

        assertTrue(customer.isPresent());
        assertAll("Check customer values",
                () -> assertEquals("2345675434544345", ((Customer) customer.get()).getCnpj()),
                () -> assertEquals("Seivid dos Dantos", ((Customer) customer.get()).getName()),
                () -> assertEquals("Tech", ((Customer) customer.get()).getBusinessArea())
        );
    }

    @Test
    public void parseAnNotElegibleLineShouldThrowIllegalStateExceptionWithMessage() {
        String lineWithIncorrectCustomer = "002ç2345675434544345ç8888888çComercial";

        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> customerParser.parse(lineWithIncorrectCustomer));

        assertEquals("No match found", exception.getMessage());
    }

    @Test
    public void verifyIfLineIsEligibleWithSuccessShouldReturnTrue() {
        String lineWithCorrectCustomer = "002ç2345675434544345çRarcio MafaelçProducts";

        Boolean isEligible =  customerParser.isElegible(lineWithCorrectCustomer);

        assertTrue(isEligible);
    }

    @Test
    public void verifyIfLineIsEligibleWithErrorShouldReturnFalse() {
        String lineWithIncorrectCustomer = "002ç2345675434544345çRarcelo Mocha-Business";

        Boolean isEligible =  customerParser.isElegible(lineWithIncorrectCustomer);

        assertFalse(isEligible);
    }

}
