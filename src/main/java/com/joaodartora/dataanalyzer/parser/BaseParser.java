package com.joaodartora.dataanalyzer.parser;

import com.joaodartora.dataanalyzer.model.BaseModel;

import java.util.Optional;

public interface BaseParser {

    Optional<BaseModel> parse(String line);

    Boolean isElegible(String line);

}
