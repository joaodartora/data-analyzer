package com.joaodartora.dataanalyzer.test.stub;

import com.joaodartora.dataanalyzer.model.Customer;

public class CustomerStub {

    public static Customer createCustomer() {
        return Customer.of()
                .businessArea("Tech")
                .cnpj("89663784000130")
                .name("Arlindo")
                .build();
    }
}
