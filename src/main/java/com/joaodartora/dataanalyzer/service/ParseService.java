package com.joaodartora.dataanalyzer.service;

import com.joaodartora.dataanalyzer.exception.InvalidParseTypeException;
import com.joaodartora.dataanalyzer.model.BaseModel;
import com.joaodartora.dataanalyzer.parser.factory.ParserFactory;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ParseService {

    private final static Logger logger = Logger.getLogger(String.valueOf(ParseService.class));

    private final ParserFactory parserFactory = new ParserFactory();

    public List<BaseModel> parseLinesAccordingToType(List<String> lines) {
        return lines.stream()
                .filter(this::isNotEmptyAndNotNull)
                .map(this::getBaseModelFactory)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private boolean isNotEmptyAndNotNull(String line) {
        return !"".equals(line) && line != null;
    }

    private Optional<BaseModel> getBaseModelFactory(String line) throws InvalidParseTypeException{
        try {
            return parserFactory.get()
                    .filter(baseParser -> baseParser.isElegible(line))
                    .findFirst()
                    .orElseThrow(InvalidParseTypeException::new)
                    .parse(line);
        } catch (InvalidParseTypeException e) {
            logger.log(Level.WARNING, "Error trying to find a parser for this line", e);
            return Optional.empty();
        }
    }
}
