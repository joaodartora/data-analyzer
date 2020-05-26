package com.joaodartora.dataanalyzer.test.stub;

import com.joaodartora.dataanalyzer.model.Item;
import com.joaodartora.dataanalyzer.model.Sales;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SalesStub {

    public static Sales createSales() {
        return Sales.of()
                .saleId(3108)
                .item(createSalesItemsList(3))
                .salesmanName("Astolfinho Maciel")
                .build();
    }

    private static List<Item> createSalesItemsList(Integer size) {
        return IntStream.range(0, size)
                .mapToObj(index -> createItem(++index))
                .collect(Collectors.toList());
    }

    private static Item createItem(Integer id) {
        return Item.of()
                .id(id)
                .price(BigDecimal.valueOf(5).multiply(BigDecimal.valueOf(id)))
                .quantity(2 * id)
                .build();
    }
}
