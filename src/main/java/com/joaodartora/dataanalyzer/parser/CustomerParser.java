package com.joaodartora.dataanalyzer.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Customer;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerParser implements BaseParser {

    private static final String CUSTOMER_REGEX = "002ç([0-9]{14,16})ç([ a-zA-Z áç]+)ç([ a-zA-Z áç]+)";
    private static final Integer CNPJ_INDEX = 1;
    private static final Integer NAME_INDEX = 2;
    private static final Integer AREA_INDEX = 3;

    public Optional<BaseModel> parse(String line) {
        Matcher matcher = getMatcher(line);
        return Optional.of(
                Customer.of()
                        .cnpj(matcher.group(CNPJ_INDEX))
                        .name(matcher.group(NAME_INDEX))
                        .businessArea(matcher.group(AREA_INDEX))
                        .build());
    }

    public Boolean isElegible(String line) {
        return getMatcher(line).matches();
    }

    private Matcher getMatcher(String line) {
        Pattern pattern = Pattern.compile(CUSTOMER_REGEX);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }
}
