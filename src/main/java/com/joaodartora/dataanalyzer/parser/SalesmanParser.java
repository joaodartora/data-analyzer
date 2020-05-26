package com.joaodartora.dataanalyzer.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.model.Salesman;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesmanParser implements BaseParser {

    private static final String SALESMAN_REGEX = "001ç([0-9]{9,14})ç([ a-zA-Z áç]+)ç([0-9]*\\.?[0-9]*)";
    private static final Integer CPF_INDEX = 1;
    private static final Integer NAME_INDEX = 2;
    private static final Integer SALARY_INDEX = 3;

    public Optional<BaseModel> parse(String line) {
        Matcher matcher = getMatcher(line);
        return Optional.of(
                Salesman.of()
                        .cpf(matcher.group(CPF_INDEX))
                        .name(matcher.group(NAME_INDEX))
                        .salary(new BigDecimal(matcher.group(SALARY_INDEX)))
                        .build());
    }

    public Boolean isElegible(String line) {
        return getMatcher(line).matches();
    }

    private Matcher getMatcher(String line) {
        Pattern pattern = Pattern.compile(SALESMAN_REGEX);
        Matcher matcher = pattern.matcher(line);
        matcher.find();
        return matcher;
    }

}
