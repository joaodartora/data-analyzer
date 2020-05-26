package com.joaodartora.dataanalyzer.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Item;
import com.joaodartora.dataanalyzer.model.Sales;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SalesParser implements BaseParser {

    private static final String SALE_PATTERN = "^(003)ç([0-9]{0,})ç(\\[[0-9\\-\\,\\.]+\\])ç([\\s\\S]+)";
    private static final String SALES_ITENS_PATTERN = "([-+]?[0-9]*\\.?[0-9]*)-([-+]?[0-9]*\\.?[0-9]*)-([-+]?[0-9]*\\.?[0-9]*)";
    private static final Integer SALE_ID_INDEX = 2;
    private static final Integer SALE_ITEMS_INDEX = 3;
    private static final Integer SALESMAN_NAME_INDEX = 4;
    private static final Integer ITEM_ID_INDEX = 1;
    private static final Integer ITEM_PRICE_INDEX = 2;
    private static final Integer ITEM_QUANTITY_INDEX = 3;
    private static final String ITEM_DELIMITER = ",";

    public Optional<BaseModel> parse(String line) {
        Matcher matcher = getMatcher(line, SALE_PATTERN);
        return Optional.of(
                Sales.of()
                        .saleId(Integer.valueOf(matcher.group(SALE_ID_INDEX)))
                        .item(getSaleItems(matcher.group(SALE_ITEMS_INDEX)))
                        .salesmanName(matcher.group(SALESMAN_NAME_INDEX))
                        .build());
    }

    public Boolean isElegible(String line) {
        return getMatcher(line, SALE_PATTERN).matches();
    }

    private Matcher getMatcher(String line, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }

    private List<Item> getSaleItems(String list) {
        return Arrays.stream(list.split(ITEM_DELIMITER))
                .map(item -> getSaleItem(getMatcher(item, SALES_ITENS_PATTERN)))
                .collect(Collectors.toList());
    }

    private Item getSaleItem(Matcher matcher) {
        return Item.of()
                .id(Integer.valueOf(matcher.group(ITEM_ID_INDEX)))
                .quantity(Integer.valueOf(matcher.group(ITEM_PRICE_INDEX)))
                .price(new BigDecimal(matcher.group(ITEM_QUANTITY_INDEX)))
                .build();
    }

}
