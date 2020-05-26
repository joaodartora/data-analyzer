package com.joaodartora.dataanalyzer.test.stub;

import com.joaodartora.dataanalyzer.model.Salesman;

import java.math.BigDecimal;

public class SalesmanStub {

    public static Salesman createSalesman() {
        return Salesman.of()
                .cpf("75563189951")
                .name("Leonaldo")
                .salary(BigDecimal.valueOf(5000))
                .build();
    }
}
